package android.lifeistech.com.foode2;

/**
 * Created by kawamuradaisuke on 2018/05/05.
 */

public class Geometory {

    private static final String TAG = Geometory.class.getSimpleName();
    private final Geometory self = this;

    private Location location;

    public Geometory(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
