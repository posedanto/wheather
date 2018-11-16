package sudden.rain.today.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import sudden.rain.today.R;
import sudden.rain.today.data.model.DailyForecast;
import sudden.rain.today.util.DateUtil;
import sudden.rain.today.util.IconWeatherResolver;

public class DailyForecastsView extends LinearLayout {

    private static final int VISIBLE_FORECASTS_COUNT = 4;

    public DailyForecastsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOrientation(VERTICAL);
    }

    public void setDailyForecasts(ArrayList<DailyForecast> forecasts) {
        for (int i = 0; i < VISIBLE_FORECASTS_COUNT && i < forecasts.size(); i++) {
            View item = View.inflate(getContext(), R.layout.item_forecast_daily, null);
            TextView tvTemperatureDay = item.findViewById(R.id.tvTemperatureDay);
            TextView tvTemperatureNight = item.findViewById(R.id.tvTemperatureNight);
            TextView tvDay = item.findViewById(R.id.tvDay);
            TextView tvWeather = item.findViewById(R.id.tvWeather);
            ImageView imgWeatherIconDay = item.findViewById(R.id.imgWeatherIconDay);
            ImageView imgWeatherIconNight = item.findViewById(R.id.imgWeatherIconNight);

            DailyForecast forecast = forecasts.get(i);
            tvTemperatureDay.setText(String.valueOf(forecast.getTemperature().getMaximum().getValue()));
            tvTemperatureNight.setText(String.valueOf(forecast.getTemperature().getMinimum().getValue()));
            tvDay.setText(DateUtil.getDateByTimestamp(forecast.getEpochDate()));
            tvWeather.setText(forecast.getDay().getWeather());
            imgWeatherIconDay.setImageResource(IconWeatherResolver.getIdIcon(forecast.getDay().getIcon()));
            imgWeatherIconNight.setImageResource(IconWeatherResolver.getIdIcon(forecast.getNight().getIcon()));

            addView(item);
        }
    }
}
