package id.teambantu.bcuilib;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import id.teambantu.bcuilib.utils.BCTimeWathcer;
import id.teambantu.bcuilib.utils.BCUtils;


public class BCTime extends androidx.appcompat.widget.AppCompatTextView {
    long timestamp;
    String pre = "", after = "";
    BCTimeWathcer timeWatcher = BCTimeWathcer.getInstance();
    private BCUtils bcUtils;
    Type type = Type.DEFAULT;


    public BCTime(Context context) {
        super(context);
    }

    public BCTime(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BCTime(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BCTime setTimeStamp(long timestamp) {
        this.timestamp = timestamp;
        bcUtils = new BCUtils(timestamp);
        timeWatcher.attach(this);
        return this;
    }

    public BCTime setPre(String pre) {
        this.pre = pre;
        return this;
    }

    public BCTime setFuture(Type type) {
        this.type = type;
        return this;
    }

    public BCTime setAfter(String after) {
        this.after = after;
        return this;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        timeWatcher.detached(this);
    }

    public void update() {
        if (type.equals(Type.FUTURE))  {
            bcUtils.futureTime(timestamp);
            if(!bcUtils.isAfter(timestamp)) {
                setText(String.format("Waktu %s habis", pre.toLowerCase()));
                return;
            }
        } else if(type.equals(Type.CUSTOM)) bcUtils.customTime(timestamp); else bcUtils.calculateTime(timestamp);

        String text = pre.isEmpty() ? bcUtils.getTime() : bcUtils.getTime().toLowerCase();

        setText(String.format("%s%s %s", pre, text, after));
    }

    public long getTimestamp() {
        return timestamp;
    }

    public enum Type{
        FUTURE, CUSTOM, DEFAULT
    }
}
