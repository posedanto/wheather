package sudden.rain.today.util;

import java.util.Locale;

public class LocaleUtil {

    public static String getLocale() {
        return Locale.getDefault().toString().toLowerCase().replace("_", "-");
    }
}
