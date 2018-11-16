package sudden.rain.today.data.network.response;

import com.google.gson.annotations.SerializedName;

import sudden.rain.today.data.model.QuantityWind;
import sudden.rain.today.data.model.TwoSystemQuantity;

public class ResponseCurrentCondition {

    @SerializedName("EpochTime")
    private long epochTime;

    @SerializedName("WeatherText")
    private String weatherText;

    @SerializedName("WeatherIcon")
    private int weatherIcon;

    @SerializedName("IsDayTime")
    private boolean isDayTime;

    @SerializedName("Temperature")
    private TwoSystemQuantity temperature;

    @SerializedName("RealFeelTemperature")
    private TwoSystemQuantity realFeelTemperature;

    @SerializedName("RelativeHumidity")
    private int relativeHumidity;

    @SerializedName("Wind")
    private QuantityWind wind;

    @SerializedName("UVIndex")
    private int uvIndex;

    @SerializedName("Visibility")
    private TwoSystemQuantity visibility;

    @SerializedName("CloudCover")
    private int cloudCover;

    @SerializedName("Pressure")
    private TwoSystemQuantity pressure;

    public long getEpochTime() {
        return epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public boolean isDayTime() {
        return isDayTime;
    }

    public TwoSystemQuantity getTemperature() {
        return temperature;
    }

    public TwoSystemQuantity getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public QuantityWind getWind() {
        return wind;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public TwoSystemQuantity getVisibility() {
        return visibility;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public TwoSystemQuantity getPressure() {
        return pressure;
    }
}
