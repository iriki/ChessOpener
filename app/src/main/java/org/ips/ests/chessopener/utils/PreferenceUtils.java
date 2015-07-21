package org.ips.ests.chessopener.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by hsousa on 21/07/15.
 */
public class PreferenceUtils {

    private static final String FIRST_USAGE_PREFERENCE_KEY = "com.facebook.sdk.appEventPreferences";

    /**
     * Reads if user as ever entered the app.
     * @param context
     * @return
     */
    public static boolean isFirstUsage(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(FIRST_USAGE_PREFERENCE_KEY, true);
    }

    /**
     * Sets if it's the first the user is entering the app.
     *
     * @param context   Used to persist this value across app runs.
     */
    public static void setFirstUsage(Context context, boolean firstUsage) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(FIRST_USAGE_PREFERENCE_KEY, firstUsage);
        editor.apply();
    }
}
