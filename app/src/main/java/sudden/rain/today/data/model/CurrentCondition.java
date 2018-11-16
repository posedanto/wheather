package sudden.rain.today.data.model;

public class CurrentCondition {

    private long epochTime;

    private String weatherText,
            windDirection;

    private boolean isDayTime;

    private int weatherIcon,
            relativeHumidity,
            uvIndex,
            cloudCover;

    private float temperature,
            realFeelTemperature,
            windSpeed,
            visibility,
            pressure;

    public CurrentCondition(long epochTime, String weatherText, String windDirection,
                            boolean isDayTime, int weatherIcon, int relativeHumidity,
                            int uvIndex, int cloudCover, float temperature,
                            float realFeelTemperature, float windSpeed,
                            float visibility, float pressure) {

        this.epochTime = epochTime;
        this.weatherText = weatherText;
        this.windDirection = windDirection;
        this.isDayTime = isDayTime;
        this.weatherIcon = weatherIcon;
        this.relativeHumidity = relativeHumidity;
        this.uvIndex = uvIndex;
        this.cloudCover = cloudCover;
        this.temperature = temperature;
        this.realFeelTemperature = realFeelTemperature;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.pressure = pressure;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public boolean isDayTime() {
        return isDayTime;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public float getVisibility() {
        return visibility;
    }

    public float getPressure() {
        return pressure;
    }
}
