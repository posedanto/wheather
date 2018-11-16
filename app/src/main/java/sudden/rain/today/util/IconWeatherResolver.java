package sudden.rain.today.util;

import sudden.rain.today.R;

public class IconWeatherResolver {
    public static int getIdIcon(int icon) {
        switch (icon) {
            case 1:
            case 2:
            case 3:
                return R.drawable.icon_clear_day;
            case 4:
            case 5:
            case 6:
                return R.drawable.icon_cloudy_day;
            case 7:
                return R.drawable.icon_cloudy;
            case 8:
                return R.drawable.icon_overcast;
            case 11:
                return R.drawable.icon_fog;
            case 12:
                return R.drawable.icon_showers;
            case 13:
            case 14:
                return R.drawable.icon_showers_day;
            case 15:
                return R.drawable.icon_storm;
            case 16:
            case 17:
                return R.drawable.icon_storm_day;
            case 18:
                return R.drawable.icon_rain;
            case 19:
            case 22:
                return R.drawable.icon_snow;
            case 20:
            case 21:
            case 23:
                return R.drawable.icon_snow_day;
            case 24:
                return R.drawable.icon_ice;
            case 25:
            case 26:
            case 29:
                return R.drawable.icon_sleet;
            case 30:
                return R.drawable.icon_hot;
            case 31:
                return R.drawable.icon_cold;
            case 32:
                return R.drawable.icon_wind;
            case 33:
            case 34:
            case 35:
                return R.drawable.icon_clear_night;
            case 36:
            case 37:
            case 38:
                return R.drawable.icon_cloudy_night;
            case 39:
            case 40:
                return R.drawable.icon_showers_night;
            case 41:
            case 42:
                return R.drawable.icon_storm_night;
            case 43:
            case 44:
                return R.drawable.icon_snow_night;
            default:
                return R.drawable.icon_fog;
        }
    }
}
