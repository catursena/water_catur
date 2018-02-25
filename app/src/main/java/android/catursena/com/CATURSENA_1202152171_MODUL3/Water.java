package android.catursena.com.CATURSENA_1202152171_MODUL3;

/**
 * Created by catursena on 25/02/18.
 */

public class Water {

    private  String title;
    private String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "ImageResource";


    public Water(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }
    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

    }


