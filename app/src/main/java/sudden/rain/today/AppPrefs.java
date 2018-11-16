package sudden.rain.today;

import android.content.SharedPreferences;

import sudden.rain.today.util.PrefUtil;

public class AppPrefs {

    private static final String KEY_ID_CITY = "id_city";
    private static final String KEY_IS_METRIC = "is_metric";

    private static String idCity;
    private static boolean isMetric;

    public static void initPrefs() {
        SharedPreferences preferences = PrefUtil.getPrefs();

        idCity = preferences.getString(KEY_ID_CITY, null);
        isMetric = preferences.getBoolean(KEY_IS_METRIC, true);
    }

    public static void setIdCity(String idCity) {
        AppPrefs.idCity = idCity;
        PrefUtil.getEditor().putString(KEY_ID_CITY, idCity).commit();
    }

    public static void setIsMetric(boolean isMetric) {
        AppPrefs.isMetric = isMetric;
        PrefUtil.getEditor().putBoolean(KEY_IS_METRIC, isMetric).commit();
    }

    public static String getIdCity() {
        return idCity;
    }

    public static boolean isIsMetric() {
        return isMetric;
    }
}
