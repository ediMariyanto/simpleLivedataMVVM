package id.co.kalacakra.simpleLivedataMVVM.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;

public class GlobalFunc {

    @SuppressLint("HardwareIds")
    public static String GET_DEVICE_ID(Context ctx) {
        return Settings.Secure.getString(ctx.getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static String GET_DEVICE_NAME() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    @SuppressLint("HardwareIds")
    public static String GET_IP_ADDRESS(Context ctx) {
        WifiManager wm = (WifiManager) ctx.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }

    public static String GET_PREFFERENCE(Context context, String preffName, String preffKey) {
        String value = "";
        if (context != null && preffName != null && preffKey != null) {
            SharedPreferences settings = context.getSharedPreferences(preffName, Context.MODE_PRIVATE);
            value = settings.getString(preffKey, "");
        }
        return value;
    }

}
