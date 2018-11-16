package sudden.rain.today.data.repository;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sudden.rain.today.BuildConfig;
import sudden.rain.today.App;
import sudden.rain.today.data.network.IAccuWeatherAPI;
import sudden.rain.today.data.network.response.ResponseDailyForecasts;
import sudden.rain.today.data.repository.callback.IRepositoryDailyForecastsCallback;

public class RepositoryDailyForecasts implements IRepositoryDailyForecasts {

    @Inject
    IAccuWeatherAPI weatherAPI;

    private WeakReference<IRepositoryDailyForecastsCallback> refCallback;

    private Call<ResponseDailyForecasts> request;

    public RepositoryDailyForecasts() {
        App.getComponent().inject(this);
    }

    @Override
    public void requestDailyForecasts(String location, String lang, boolean details, boolean metric, IRepositoryDailyForecastsCallback callback) {
        if (request != null) {
            request.cancel();
        }

        refCallback = new WeakReference<>(callback);

        request = weatherAPI.getDailyForecast(location, BuildConfig.API_KEY, lang, details, metric);
        request.enqueue(new Callback<ResponseDailyForecasts>() {
            @Override
            public void onResponse(Call<ResponseDailyForecasts> call, Response<ResponseDailyForecasts> response) {
                if (refCallback != null && refCallback.get() != null) {
                    if (response.body() != null) {
                        refCallback.get().onDailyForecastsLoaded(response.body().getDailyForecasts());
                        return;
                    }
                }
                onFailure(call, new Exception());
            }

            @Override
            public void onFailure(Call<ResponseDailyForecasts> call, Throwable t) {

                System.out.println("not ok");
            }
        });
    }
}
