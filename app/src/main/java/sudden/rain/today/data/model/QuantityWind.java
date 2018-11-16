package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class QuantityWind {

    @SerializedName("Direction")
    private Direction direction;

    @SerializedName("Speed")
    private TwoSystemQuantity speed;

    public Direction getDirection() {
        return direction;
    }

    public TwoSystemQuantity getSpeed() {
        return speed;
    }

    public class Direction {
        @SerializedName("Degrees")
        private int degrees;

        @SerializedName("Localized")
        private String directionLocalized;

        @SerializedName("English")
        private String directionEnglish;

        public int getDegrees() {
            return degrees;
        }

        public String getDirectionLocalized() {
            return directionLocalized;
        }

        public String getDirectionEnglish() {
            return directionEnglish;
        }
    }
}
