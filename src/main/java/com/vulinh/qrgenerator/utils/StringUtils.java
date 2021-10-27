package com.vulinh.qrgenerator.utils;

public final class StringUtils {

    public static final String EMPTY = "";
    public static final String EMPTY_LITERAL = "Empty";

    private StringUtils() {
        throw new UnsupportedOperationException("Cannot instantiate utility class!");
    }

    public static boolean isNotBlank(CharSequence data) {
        return !isBlank(data);
    }

    public static boolean isBlank(CharSequence data) {
        int length = length(data);

        if (length == 0) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(data.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    private static int length(CharSequence data) {
        return data == null ? 0 : data.length();
    }
}