package id.teambantu.bcuilib.event;

import id.teambantu.bcuilib.R;

public abstract class BCDialogButton {
    private String text = "";
    private int color = R.color.primaryDark;
    public BCDialogButton(){}
    public BCDialogButton(String text){
        this.text = text;
    }

    public BCDialogButton(String text, int color){
        this.text = text;
        this.color = color;
    }

    public String getText(){return text;}
    public int color(){return color;}
    public abstract void onClickListener();
}
