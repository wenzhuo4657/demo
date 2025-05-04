package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Dateutils {
    private static final SimpleDateFormat sim = new SimpleDateFormat();

    //    字符串转util.Date
    public static java.util.Date strDate(String str) {
        try {
            return sim.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }


    //    util.Date转sql
    public static java.sql.Date utilTosql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    //    util转字符串
    public static String utilToStr(java.util.Date date) {
        return sim.format(date);
    }


}
