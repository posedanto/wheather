package sudden.rain.today.data.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import sudden.rain.today.data.model.DailyForecast;

public class ResponseDailyForecasts {

    @SerializedName("DailyForecasts")
    private ArrayList<DailyForecast> dailyForecasts;

    public ArrayList<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }
}
