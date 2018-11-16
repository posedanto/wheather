package sudden.rain.today.data.mapper;

import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.network.response.ResponseCurrentCondition;

public class MapperCurrentCondition {
    public static CurrentCondition mapResponseCurrentCondition(ResponseCurrentCondition response,
                                                               boolean isMetric) {

        return new CurrentCondition(
                response.getEpochTime(),
                response.getWeatherText(),
                response.getWind().getDirection().getDirectionLocalized(),
                response.isDayTime(),
                response.getWeatherIcon(),
                response.getRelativeHumidity(),
                response.getUvIndex(),
                response.getCloudCover(),
                isMetric ? response.getTemperature().getMetric().getValue() : response.getTemperature().getImperial().getValue(),
                isMetric ? response.getRealFeelTemperature().getMetric().getValue() : response.getRealFeelTemperature().getImperial().getValue(),
                isMetric ? response.getWind().getSpeed().getMetric().getValue() : response.getWind().getSpeed().getImperial().getValue(),
                isMetric ? response.getVisibility().getMetric().getValue() : response.getVisibility().getImperial().getValue(),
                isMetric ? response.getPressure().getMetric().getValue() : response.getPressure().getImperial().getValue()
        );
    }
}
