package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class DailyForecast {

    @SerializedName("EpochDate")
    private long epochDate;

    @SerializedName("Temperature")
    private DailyTemperature temperature;

    @SerializedName("Day")
    private HalfDayCondition day;

    @SerializedName("Night")
    private HalfDayCondition night;

    public long getEpochDate() {
        return epochDate;
    }

    public DailyTemperature getTemperature() {
        return temperature;
    }

    public HalfDayCondition getDay() {
        return day;
    }

    public HalfDayCondition getNight() {
        return night;
    }
}
