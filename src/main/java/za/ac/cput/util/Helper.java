package za.ac.cput.util;


/**
 * Helper.java
 *
 * @author Zachariah Matsimella
 * Student Num: 220097429
 * @date 06-Sep-24
 */

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isLongNullOrEmpty(Long l) {
        return l == null;
    }

    public static boolean isDoubleNullorEmpty(Double s) {
        return s == null || Double.isNaN(s);
    }
}
