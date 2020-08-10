package id.teambantu.bcuilib.ui.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class NudeButton extends androidx.appcompat.widget.AppCompatButton {

    private Context context;

    public NudeButton(Context context) {
        super(context);
        this.context = context;
    }

    public NudeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public NudeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Typeface typeface = Typeface.create("neo_sans_pro_medium", Typeface.BOLD);
        setTypeface(typeface);
    }
}
