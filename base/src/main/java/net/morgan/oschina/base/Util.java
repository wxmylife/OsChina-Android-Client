package net.morgan.oschina.base;

import android.text.TextUtils;

/**
 * Created by wxmylife on 2017/8/8.
 */

public class Util {
    public static boolean isNull(String... args) {
        if (args == null) return true;
        for (String item : args) {
            if (TextUtils.isEmpty(item)) return true;
        }
        return false;
    }
}
