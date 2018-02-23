package app.listview.pedor.com.friendsr;

import java.io.Serializable;

/**
 * Created by Dico on 22-2-2018.
 */

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
