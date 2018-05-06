package android.lifeistech.com.foode2;

/**
 * Created by kawamuradaisuke on 2018/05/06.
 */

public class Location {

    public static final String TAG = Location.class.getSimpleName();

    public final Location self = this;

    private double lat;
    private double lng;

    public Location(double lat,double lng){
        this.lat = lat;
        this.lng = lng;

    }

    public double getLat(){
        return lat;
    }

    public void setLat(double lat){
        this.lat = lat;
    }



    public double getLng(){
        return lng;
    }

    public void setLng(double lng){
        this.lng = lng;

    }

}
