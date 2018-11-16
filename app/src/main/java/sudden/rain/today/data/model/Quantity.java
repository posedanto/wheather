package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class Quantity {

    @SerializedName("Value")
    private float value;

    @SerializedName("Unit")
    private String unit;

    @SerializedName("UnitType")
    private int unitType;

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public int getUnitType() {
        return unitType;
    }
}
