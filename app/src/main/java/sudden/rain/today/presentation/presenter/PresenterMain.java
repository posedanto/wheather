package sudden.rain.today.presentation.presenter;

import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;

import sudden.rain.today.App;
import sudden.rain.today.AppPrefs;
import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.model.DailyForecast;
import sudden.rain.today.data.model.Location;
import sudden.rain.today.data.repository.IRepositoryCurrentCondition;
import sudden.rain.today.data.repository.IRepositoryDailyForecasts;
import sudden.rain.today.data.repository.IRepositoryLocations;
import sudden.rain.today.data.repository.callback.IRepositoryCurrentConditionCallback;
import sudden.rain.today.data.repository.callback.IRepositoryDailyForecastsCallback;
import sudden.rain.today.data.repository.callback.IRepositoryLocationCallback;
import sudden.rain.today.presentation.contract.ContractMain;
import sudden.rain.today.util.LocaleUtil;

public class PresenterMain extends PresenterBase<ContractMain.View> implements ContractMain.Presenter {

    @Inject
    IRepositoryDailyForecasts repositoryDailyForecasts;

    @Inject
    IRepositoryCurrentCondition repositoryCurrentCondition;

    @Inject
    IRepositoryLocations repositoryLocations;

    private int awaitedResponse;

    public PresenterMain() {
        App.getComponent().inject(this);
    }

    private void requestGeoposition() {
        if (getView() != null)
            getView().requestLocation();
    }

    @Override
    public void attachView(ContractMain.View view) {
        super.attachView(view);
        if (AppPrefs.getIdCity() == null) {
            requestGeoposition();
        } else {
            requestAllForecasts();
        }
    }

    private void requestAllForecasts() {
        String idCity = AppPrefs.getIdCity();
        awaitedResponse = 2;

        repositoryCurrentCondition.requestCurrentCondition(idCity, LocaleUtil.getLocale(), true,
                new RepositoryCurrentConditionCallback());

        repositoryDailyForecasts.requestDailyForecasts(idCity, LocaleUtil.getLocale(), true, true,
                new RepositoryDailyForecastsCallback());
    }

    private void showForecasts() {
        if (awaitedResponse == 0) {
            if (getView() != null)
                getView().showForecasts();
        }
    }

    @Override
    public void onLocationFound(String position) {
        repositoryLocations.requestLocationByGeoposition(position, new RepositoryLocationCallback());
    }

    private class RepositoryLocationCallback implements IRepositoryLocationCallback {
        @Override
        public void onLocationLoaded(Location location) {
            AppPrefs.setIdCity(location.getKey());
        }

        @Override
        public void onFailure(Throwable throwable) {
            System.out.println("fail");
        }
    }

    private class RepositoryCurrentConditionCallback implements IRepositoryCurrentConditionCallback {
        @Override
        public void onCurrentConditionLoaded(CurrentCondition condition) {
            if (getView() != null)
                getView().updateCurrentCondition(condition);

            awaitedResponse --;
            showForecasts();
        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    }

    private class RepositoryDailyForecastsCallback implements IRepositoryDailyForecastsCallback {
        @Override
        public void onDailyForecastsLoaded(ArrayList<DailyForecast> forecasts) {
            if (getView() != null)
                getView().updateDailyForecasts(forecasts);

            awaitedResponse --;
            showForecasts();
        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    }
}
