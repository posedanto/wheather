package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class TwoSystemQuantity {

    @SerializedName("Metric")
    private Quantity metric;

    @SerializedName("Imperial")
    private Quantity imperial;

    public Quantity getMetric() {
        return metric;
    }

    public Quantity getImperial() {
        return imperial;
    }
}
