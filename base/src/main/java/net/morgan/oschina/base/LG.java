package net.morgan.oschina.base;

import android.util.Log;

/**
 * Created by wxmylife on 2017/4/20.
 */

public class LG {

    private static final String DETAULT_TAG = "---Module Sample Log>>>";
    public static boolean isDebug = false;

    public static void d(String msg) {
        d(DETAULT_TAG, msg);
    }

    private static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void e(String msg) {
        e(DETAULT_TAG, msg);
    }

    private static void e(String tag, String msg) {
        Log.e(tag, msg);
    }


}
