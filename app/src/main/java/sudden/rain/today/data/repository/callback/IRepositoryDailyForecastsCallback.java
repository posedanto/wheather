package sudden.rain.today.data.repository.callback;

import java.util.ArrayList;

import sudden.rain.today.data.model.DailyForecast;

public interface IRepositoryDailyForecastsCallback {
    void onDailyForecastsLoaded(ArrayList<DailyForecast> forecasts);

    void onFailure(Throwable throwable);
}
