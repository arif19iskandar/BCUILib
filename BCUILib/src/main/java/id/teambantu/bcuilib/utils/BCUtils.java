package id.teambantu.bcuilib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class BCUtils {
    public static final HashMap<String, Integer> units;
    boolean future;
    static {
        units = new HashMap<String, Integer>();
        units.put("minute", 60);
        units.put("hour", 3600);
        units.put("day", 86400);
        units.put("week", 604800);
        units.put("month", 2592000);
        units.put("year", 31104000);

    }
    String time;

    public BCUtils(long timeStamp){
        calculateTime(timeStamp);
    }

    public String getTime() {
        return time;
    }

    public boolean isAfter(long timestamp){
        return new Date().before(new Date(timestamp));
    }

    public void futureTime(long timeStamp){
        long diff = (getCurrentTimeStamp() - timeStamp)/1000;
        future = true;
        diffToString(diff);
    }

    public void calculateTime(long timeStamp) {
        long diff = (getCurrentTimeStamp() - timeStamp)/1000;
        future = false;
        diffToString(diff);
    }

    public void customTime(long timeStamp){
        Date f = new Date(timeStamp);
        Date n = new Date();
        int diff = f.getDate() - n.getDate();

        if( diff == 0){
            SimpleDateFormat format = new SimpleDateFormat("HH:MM");
            Date date = new Date(timeStamp);
            time = format.format(date);
        } else if(diff == -1) {
            time = BCFutureString.ONE_DAY_AGO;
        }else if(diff > -7){
            Date date = new Date(timeStamp);
            time = BCDateFormat.WEEKDAYS[date.getDay()];
        } else {
            SimpleDateFormat format = new SimpleDateFormat("YYYY");
            Date date = new Date(timeStamp);
//            time = format.format(date);
            time = date.getDate() + " " + BCDateFormat.MONTHS[date.getMonth()] + " " + format.format(date);
        }
    }

    private void diffToString(long diff) {
        long abs_diff = Math.abs(diff);
        if (abs_diff < units.get("minute")) {
            //NOW
            if(diff < 0){
                time = future ? BCFutureString.IN_FEW_SECONDS : BCRelativeTimeString.IN_FEW_SECONDS;
            }else{
                time = future ? BCFutureString.NOW : BCRelativeTimeString.NOW;
            }
        } else if (abs_diff < units.get("hour")) {
            //MINS
            getTimeString(diff, "minute", future ? BCFutureString.MINUTE : BCRelativeTimeString.MINUTE, future ? BCFutureString.MINUTES : BCRelativeTimeString.MINUTES);
        } else if (abs_diff < units.get("day")) {
            //HOURS
            getTimeString(diff, "hour", future ? BCFutureString.HOUR : BCRelativeTimeString.HOUR, future ? BCFutureString.HOURS: BCRelativeTimeString.HOURS);
        } else if (abs_diff < units.get("week")) {
            //DAYS
            getTimeString(diff, "day", future ? BCFutureString.DAY : BCRelativeTimeString.DAY, future ? BCFutureString.DAYS : BCRelativeTimeString.DAYS);
        } else if (abs_diff < units.get("month")) {
            //WEEKS
            getTimeString(diff, "week", future ? BCFutureString.WEEK : BCRelativeTimeString.WEEK, future ? BCFutureString.WEEKS : BCRelativeTimeString.WEEKS);
        } else if (abs_diff < units.get("year")) {
            //MONTHS
            getTimeString(diff, "month", future ? BCFutureString.MONTH : BCRelativeTimeString.MONTH, future ? BCFutureString.MONTHS : BCRelativeTimeString.MONTHS);
        } else {
            //YEARS
            getTimeString(diff, "year", future ? BCFutureString.YEAR : BCRelativeTimeString.YEAR, future ? BCFutureString.YEARS : BCRelativeTimeString.YEARS);
        }
    }

    private void getTimeString(long diff, String one_unit, String one_thing, String many_things) {
        int unit = units.get(one_unit);
        if (diff < 0) {
            //FUTURE
            diff = Math.abs(diff);
            if (diff < 2 * unit) {
                time = future ? BCFutureString.IN_ONE_THING.get(one_unit) : BCRelativeTimeString.IN_ONE_THING.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = (future ? BCFutureString.IN: BCRelativeTimeString.IN) + " " + String.valueOf(number_of_things) + " " + many_things;
            }
            time+= future? " " + BCFutureString.AGO : "";
        } else {
            //PAST
            if (diff < 2 * unit) {
                time = future ? BCFutureString.ONE_THING_AGO.get(one_unit) : BCRelativeTimeString.ONE_THING_AGO.get(one_unit);
            } else {
                int number_of_things = Math.round((diff / unit));
                time = String.valueOf(number_of_things) + " " + many_things + " " + (future ? BCFutureString.AGO : BCRelativeTimeString.AGO);
            }
        }
    }

    private long getCurrentTimeStamp() {
        return new Date().getTime();
    }
}
