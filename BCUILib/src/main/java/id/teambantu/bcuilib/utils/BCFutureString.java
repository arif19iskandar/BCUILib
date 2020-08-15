package id.teambantu.bcuilib.utils;

import java.util.HashMap;

public class BCFutureString {
    public static final String NOW = "Sekarang";
    public static final String IN_FEW_SECONDS = "beberapa detik";
    public static final String AGO = "lagi";
    public static final String IN = "";

    public static final String MINUTE = "menit";
    public static final String MINUTES = "menit";
    public static final String ONE_MINUTE_AGO = "Se" + MINUTE + " " + AGO;
    public static final String IN_ONE_MINUTE = IN + " se" + MINUTE;


    public static final String HOUR = "jam";
    public static final String HOURS = "jam";
    public static final String ONE_HOUR_AGO = "Se" + HOUR + " " +AGO;
    public static final String IN_ONE_HOUR = IN + " se" + HOUR;


    public static final String DAY = "hari";
    public static final String DAYS = "hari";
    public static final String ONE_DAY_AGO = "Kemarin";
    public static final String IN_ONE_DAY = "Se" + DAY;


    public static final String WEEK = "minggu";
    public static final String WEEKS = "minggu";
    public static final String ONE_WEEK_AGO = "Se" + WEEK  + " " +AGO;
    public static final String IN_ONE_WEEK = IN + " se" + WEEK;

    public static final String MONTH = "bulan";
    public static final String MONTHS = "bulan";
    public static final String ONE_MONTH_AGO = "Se" + MONTH  + " " +AGO;
    public static final String IN_ONE_MONTH = IN + " se" + MONTH;


    public static final String YEAR = "tahun";
    public static final String YEARS = "tahun";
    public static final String ONE_YEAR_AGO = "Se" + YEAR  + " " +AGO;
    public static final String IN_ONE_YEAR = IN + " se" + YEAR;

    public static final HashMap<String, String> ONE_THING_AGO;
    public static final HashMap<String, String> IN_ONE_THING;

    static {
        ONE_THING_AGO = new HashMap<String, String>();
        ONE_THING_AGO.put("minute", ONE_MINUTE_AGO);
        ONE_THING_AGO.put("day", ONE_DAY_AGO);
        ONE_THING_AGO.put("hour", ONE_HOUR_AGO);
        ONE_THING_AGO.put("week", ONE_WEEK_AGO);
        ONE_THING_AGO.put("month", ONE_MONTH_AGO);
        ONE_THING_AGO.put("year", ONE_YEAR_AGO);


    }

    static {
        IN_ONE_THING = new HashMap<String, String>();
        IN_ONE_THING.put("minute", IN_ONE_MINUTE);
        IN_ONE_THING.put("day", IN_ONE_DAY);
        IN_ONE_THING.put("hour", IN_ONE_HOUR);
        IN_ONE_THING.put("week", IN_ONE_WEEK);
        IN_ONE_THING.put("month", IN_ONE_MONTH);
        IN_ONE_THING.put("year", IN_ONE_YEAR);

    }
}
