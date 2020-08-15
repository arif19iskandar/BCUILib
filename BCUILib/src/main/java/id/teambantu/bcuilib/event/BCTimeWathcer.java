package id.teambantu.bcuilib.event;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import id.teambantu.bcuilib.BCTime;

public class BCTimeWathcer {
    private static final Handler handler = new Handler();
    private static BCTimeWathcer timeWatcher;
    private static List<BCTime> textViews = new ArrayList<BCTime>();
    private static Timer timer;
    private static TimerTask timerTask;

    public BCTimeWathcer() {
    }
    public static BCTimeWathcer getInstance(){
        if (timeWatcher == null) {
            timeWatcher = new BCTimeWathcer();
            timer = new Timer();
            initializeTimerTask();
            timer.schedule(timerTask, 1000, 1000);
        }
        return timeWatcher;
    }
    public static void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        updateTextViews();
                    }
                });
            }
        };
    }
    public void attach(BCTime textView) {
        if (!textViews.contains(textView)) {
            textViews.add(textView);
        }
    }

    public void detached(BCTime textView) {
        if (textViews.contains(textView)) textViews.remove(textView);
    }
    public static void updateTextViews() {
        for (BCTime textView : textViews) {
            textView.update();
        }
    }
}
