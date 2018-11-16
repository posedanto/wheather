package sudden.rain.today.presentation.contract;

import java.util.ArrayList;

import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.model.DailyForecast;

public interface ContractMain {

    interface View {
        void requestLocation();
        void updateCurrentCondition(CurrentCondition condition);
        void updateDailyForecasts(ArrayList<DailyForecast> forecasts);
        void showForecasts();
    }

    interface Presenter extends ContractBasePresenter<View> {
        void onLocationFound(String position);
    }
}
