package android.lifeistech.com.foode2;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by kawamuradaisuke on 2018/05/06.
 */

public class PlacesApiHelper {

    private static final String TAG = PlacesApiHelper.class.getSimpleName();
    private final PlacesApiHelper self = this;

    private Context mContext;

    public PlacesApiHelper(Context context){
        mContext = context;

    }

    public void requestPlaces(String types, LatLng latLng, int radius, Callback<Response> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MapsActivity_10.PlaceApiService service = retrofit.create(MapsActivity_10.PlaceApiService.class);
        Call<Response> call = service.requestPlaces(types,
                String.valueOf(latLng.latitude) +","+String.valueOf(latLng.longitude),
                String.valueOf(radius),
                "false",
                "AIzaSyDonRgMSNGSG_1dF2YehCscx2eHRYp5JZQ");

        call.enqueue(callback);
    }


}







//    private static final String TAG = PlacesApiHelper.class.getSimpleName();
//    private final PlacesApiHelper self = this;
//
//    private Context mContext;
//
//    public PlacesApiHelper(Context context) {
//        mContext = context;
//    }
//
//
//
//    public void requestPlaces(String types, LatLng latLng, int radius, Callback<Response> callback) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://maps.googleapis.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MapsActivity_10.PlaceApiService service = retrofit.create(MapsActivity_10.PlaceApiService.class);
//
//        Call<List<Response>> call = service.requestPlaces(types,
//                String.valueOf(latLng.latitude) + "," + String.valueOf(latLng.longitude),
//                String.valueOf(radius),
//                "false",
//                mContext.getString(Integer.parseInt("AIzaSyBKWnMuEp0It7qEksv3tIXgUEyz2PoEkIEp0It7qEksv3tlXgUEyz2PoEk")));
//        call.enqueue(callback);
//    }