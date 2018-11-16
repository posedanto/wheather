package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class HalfDayCondition {

    @SerializedName("Icon")
    private int icon;

    @SerializedName("IconPhrase")
    private String weather;

    @SerializedName("Wind")
    private QuantityWind wind;

    public int getIcon() {
        return icon;
    }

    public String getWeather() {
        return weather;
    }

    public QuantityWind getWind() {
        return wind;
    }
}
