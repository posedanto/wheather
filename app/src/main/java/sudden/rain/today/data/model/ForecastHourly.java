package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class ForecastHourly {

    @SerializedName("EpochDateTime")
    private long epochDateTime;

    @SerializedName("WeatherIcon")
    private Quantity weatherIcon;

    @SerializedName("Temperature")
    private Quantity temperature;

    @SerializedName("Wind")
    private QuantityWind wind;
}
