package sudden.rain.today.data.repository;

import sudden.rain.today.data.repository.callback.IRepositoryDailyForecastsCallback;

public interface IRepositoryDailyForecasts {
    void requestDailyForecasts(String location, String lang, boolean details, boolean metric, IRepositoryDailyForecastsCallback callback);
}
