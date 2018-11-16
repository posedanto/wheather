package sudden.rain.today.util;

import android.content.Context;
import android.content.SharedPreferences;

import sudden.rain.today.App;

public class PrefUtil {
    private static final String PREF_NAME = "weather";

    public static SharedPreferences getPrefs() {
        return App.getComponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }
}

