package android.lifeistech.com.foode2;

/**
 * Created by kawamuradaisuke on 2018/05/05.
 */

public class Result {

    private static final String TAG = Result.class.getSimpleName();
    private final Result self = this;

    private Geometory geometry;
    private String icon;
    private String id;
    private String name;
    private String place_id;
    private String rating;
    private String reference;
    private String[] types;
    private String vicinity;

    public Result(Geometory geometry, String icon, String id, String name, String place_id, String rating, String reference, String[] types, String vicinity) {
        this.geometry = geometry;
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.place_id = place_id;
        this.rating = rating;
        this.reference = reference;
        this.types = types;
        this.vicinity = vicinity;
    }

    public Geometory getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometory geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
