package sudden.rain.today.ui.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import sudden.rain.today.R;
import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.network.response.ResponseCurrentCondition;
import sudden.rain.today.util.IconWeatherResolver;

public class CurrentConditionView extends ConstraintLayout {

    private TextView tvCity, tvTemperature, tvWeather, tvFeel, tvWind, tvPressure, tvHumidity;
    private ImageView imgWeatherIcon;

    public CurrentConditionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_current_condition, this);

        tvCity = findViewById(R.id.tvCity);
        tvTemperature = findViewById(R.id.tvTemperature);
        tvWeather = findViewById(R.id.tvWeather);
        tvFeel = findViewById(R.id.tvFeel);
        tvWind = findViewById(R.id.tvWind);
        tvPressure = findViewById(R.id.tvPressure);
        tvHumidity = findViewById(R.id.tvHumidity);

        imgWeatherIcon = findViewById(R.id.imgWeatherIcon);
    }

    public void setCurrentCondition(String city, CurrentCondition condition) {

        tvCity.setText(city);
        tvTemperature.setText(String.valueOf(condition.getTemperature()));
        tvWeather.setText(condition.getWeatherText());
        tvFeel.setText(String.valueOf(condition.getRealFeelTemperature()));
        tvWind.setText(condition.getWindDirection() + " " + condition.getWindSpeed());
        tvPressure.setText(String.valueOf(condition.getPressure()));
        tvHumidity.setText(String.valueOf(condition.getRelativeHumidity()));

        imgWeatherIcon.setImageResource(IconWeatherResolver.getIdIcon(condition.getWeatherIcon()));
    }
}
