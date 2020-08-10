package id.teambantu.bcuilib.utils;

import android.net.Uri;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;

public class BCImage {
    private int resID;
    private String link;
    private Uri uri;
    private File file;
    private Type from;

    public BCImage(int resID){
        this.resID = resID;
        from = Type.RES;
    }

    public BCImage(String link) {
        this.link = link;
        from = Type.LINK;
    }

    public BCImage(Uri uri) {
        this.uri = uri;
        from = Type.URI;
    }

    public BCImage(File file) {
        this.file = file;
        from = Type.FILE;
    }

    public static BCImage from(int resID){
        return new BCImage(resID);
    }
    public static BCImage from(String link){
        return new BCImage(link);
    }
    public static BCImage from(Uri uri){
        return new BCImage(uri);
    }
    public static BCImage from(File file){
        return new BCImage(file);
    }

    public RequestCreator getImage() {
        switch (from){
            case RES: return Picasso.get().load(resID);
            case URI: return Picasso.get().load(uri);
            case LINK: return Picasso.get().load(link);
            case FILE: return Picasso.get().load(file);
        }
        return null;
    }

    enum Type{
        RES,LINK,URI,FILE
    }
}
