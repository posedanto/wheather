package sudden.rain.today.data.repository;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sudden.rain.today.BuildConfig;
import sudden.rain.today.App;
import sudden.rain.today.data.memorycache.CacheAutocompleteLocations;
import sudden.rain.today.data.model.Location;
import sudden.rain.today.data.network.IAccuWeatherAPI;
import sudden.rain.today.data.repository.callback.IRepositoryLocationCallback;
import sudden.rain.today.data.repository.callback.IRepositoryLocationsCallback;
import sudden.rain.today.util.LocaleUtil;

public class RepositoryLocations implements IRepositoryLocations {

    @Inject
    IAccuWeatherAPI weatherAPI;

    @Inject
    CacheAutocompleteLocations cacheAutocompleteLocations;

    private WeakReference<IRepositoryLocationCallback> refCallbackByGeo;
    private WeakReference<IRepositoryLocationsCallback> refCallback;

    private Call<ArrayList<Location>> request;
    private Call<Location> requestByGeo;

    public RepositoryLocations() {
        App.getComponent().inject(this);
    }

    @Override
    public void requestLocationByGeoposition(String geoposition, IRepositoryLocationCallback callback) {
        if (requestByGeo != null) {
            requestByGeo.cancel();
        }

        refCallbackByGeo = new WeakReference<>(callback);

        requestByGeo = weatherAPI.getLocationByGeoposition(BuildConfig.API_KEY, geoposition, LocaleUtil.getLocale());
        requestByGeo.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                if (response.isSuccessful()) {
                    if (refCallbackByGeo != null && refCallbackByGeo.get() != null) {
                        refCallbackByGeo.get().onLocationLoaded(response.body());
                        return;
                    }
                }
                onFailure(call, new Exception());
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                System.out.println("fail");
            }
        });
    }

    @Override
    public void requestLocationsByAutocomplete(String query, IRepositoryLocationsCallback callback) {

        if (cacheAutocompleteLocations.getLocation(query) != null) {
            callback.onLocationsLoaded(cacheAutocompleteLocations.getLocation(query));
            Log.d("TAGGG", "Locations from cache. Query: " + query);
            return;
        }

        if (request != null) {
            request.cancel();
        }

        refCallback = new WeakReference<>(callback);
        request = weatherAPI.getLocationsByAutocomplete(BuildConfig.API_KEY, query, LocaleUtil.getLocale());
        request.enqueue(new ResponseLocationsCallback());
    }

    @Override
    public void requestLocationsByCityName(String cityName, IRepositoryLocationsCallback callback) {
        if (request != null) {
            request.cancel();
        }

        refCallback = new WeakReference<>(callback);
        request = weatherAPI.getLocationsByCityName(BuildConfig.API_KEY, cityName, LocaleUtil.getLocale());
        request.enqueue(new ResponseLocationsCallback());
    }

    private class ResponseLocationsCallback implements Callback<ArrayList<Location>> {
        @Override
        public void onResponse(Call<ArrayList<Location>> call, Response<ArrayList<Location>> response) {
            if (response.isSuccessful()) {
                if (refCallback != null && refCallback.get() != null) {
                    String key = response.raw().request().url().queryParameter("q");
                    cacheAutocompleteLocations.addData(key, response.body());
                    Log.d("TAGGG", "Locations from server. Query: " + key);
                    refCallback.get().onLocationsLoaded(response.body());
                    return;
                }
            }
            onFailure(call, new Exception());
        }

        @Override
        public void onFailure(Call<ArrayList<Location>> call, Throwable t) {
            if (refCallback != null && refCallback.get() != null) {
                refCallback.get().onFailure(t);
            }
        }
    }
}
