package sudden.rain.today.data.repository;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sudden.rain.today.BuildConfig;
import sudden.rain.today.App;
import sudden.rain.today.data.mapper.MapperCurrentCondition;
import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.network.IAccuWeatherAPI;
import sudden.rain.today.data.network.response.ResponseCurrentCondition;
import sudden.rain.today.data.repository.callback.IRepositoryCurrentConditionCallback;

public class RepositoryCurrentCondition implements IRepositoryCurrentCondition {

    @Inject
    IAccuWeatherAPI weatherAPI;

    private WeakReference<IRepositoryCurrentConditionCallback> refCallback;

    private Call<ArrayList<ResponseCurrentCondition>> request;

    public RepositoryCurrentCondition() {
        App.getComponent().inject(this);
    }

    @Override
    public void requestCurrentCondition(String location, String lang, boolean details,
                                        IRepositoryCurrentConditionCallback callback) {

        if (request != null) {
            request.cancel();
        }

        refCallback = new WeakReference<>(callback);

        request = weatherAPI.getCurrentCondition(location, BuildConfig.API_KEY, lang, details);
        request.enqueue(new Callback<ArrayList<ResponseCurrentCondition>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseCurrentCondition>> call,
                                   Response<ArrayList<ResponseCurrentCondition>> response) {

                if (refCallback != null && refCallback.get() != null) {
                    CurrentCondition condition = MapperCurrentCondition
                            .mapResponseCurrentCondition(response.body().get(0), true);

                    refCallback.get().onCurrentConditionLoaded(condition);
                    return;
                }
                onFailure(call, new Exception());
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseCurrentCondition>> call, Throwable t) {
                if (refCallback != null && refCallback.get() != null)
                    refCallback.get().onFailure(t);
            }
        });
    }
}
