package com.lvy.school.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by livvy on 14/12/31.
 */
public class TokenUtils {

    private TokenUtils() {
        throw new AssertionError("no instance for you!");
    }

    private static final String privateKey = "adsadaesd,很好";

    public static String getToken(String password, String date) {
        return Hashing.md5().newHasher()
                .putString(password, Charsets.UTF_8)
                .putString(privateKey, Charsets.UTF_8)
                .putString(date, Charsets.UTF_8).hash().toString();
    }

    public static String getToken(String password, Date date) {
        return Hashing.md5().newHasher()
                .putString(password, Charsets.UTF_8)
                .putString(privateKey, Charsets.UTF_8)
                .putString(getDate(date), Charsets.UTF_8).hash().toString();
    }


    public static String getToken(String password) {
        return Hashing.md5().newHasher()
                .putString(password, Charsets.UTF_8)
                .putString(privateKey, Charsets.UTF_8)
                .putString(getDate(), Charsets.UTF_8)
                .hash().toString();
    }

    private static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
    }

    public static boolean validToken(String token,String password) {
        String confirm = getToken(password);
        return confirm.equals(token);
    }

    private static String getDate(Date now) {
        return FastDateFormat.getInstance("yyyyMMddHH").format(now);
    }

    public static String getNextHour(Date now) {
        Date date = new Date(now.getTime() + 60 * 60 * 1000);
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
    }

    public static void main(String[] args) {
        String s = getToken("这是个好人");
        System.out.println(s);

    }
}
