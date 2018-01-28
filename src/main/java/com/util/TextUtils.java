package com.util;

import com.sun.istack.internal.Nullable;

/**
 * Created by huang on 2017/5/15.
 */
public class TextUtils {

    public static boolean isEmpty(@Nullable String str) {
        return str == null || str.length() == 0 || "null".equalsIgnoreCase(str);
    }



    /**
     * 判断是否为纯数字字符串
     *
     * @param string
     * @return
     */
    public static boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
