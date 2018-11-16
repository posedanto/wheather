package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class DailyTemperature {

    @SerializedName("Minimum")
    private Quantity minimum;

    @SerializedName("Maximum")
    private Quantity maximum;

    public Quantity getMinimum() {
        return minimum;
    }

    public Quantity getMaximum() {
        return maximum;
    }
}
