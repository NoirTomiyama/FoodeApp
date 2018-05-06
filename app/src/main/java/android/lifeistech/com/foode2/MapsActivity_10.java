package android.lifeistech.com.foode2;

import android.net.sip.SipSession;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Random;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;


public class MapsActivity_10 extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = MapsActivity_10.class.getSimpleName();
    private final MapsActivity_10 self = this;

    PlacesApiHelper mHelper;

    private GoogleMap mGoogleMap;
    private LatLng mCurrentLatLng;
    TextView textView;
    Button mSearchButton;
    SipSession.Listener mOnSeachButtonClickListener;

    /**
     * URL Sample:
     * https://maps.googleapis.com/maps/api/place/search/json
     * ?types=cafe
     * &location=37.787930,-122.4074990
     * &radius=5000
     * &sensor=false
     * &key=YOUR_API_KEY
     */

    public interface PlaceApiService {
        @Headers("Accept-Language: ja")
        @GET("/maps/api/place/search/json")
        Call<Response> requestPlaces(@Query("types") String types,
                                     @Query("location") String location,
                                     @Query("radius") String radius,
                                     @Query("sensor") String sensor,
                                     @Query("key") String key);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_10);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        textView = (TextView) findViewById(R.id.textView);
        mSearchButton = (Button)findViewById(R.id.button);
        mSearchButton.setOnClickListener((View.OnClickListener) mOnSeachButtonClickListener);

        mHelper = new PlacesApiHelper(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

    }

    private View.OnClickListener mOnSearchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCurrentLatLng = new LatLng(34.45, 135.45);


            mHelper.requestPlaces("food", mCurrentLatLng, 5000, mResultCallback);
        }
    };

    private Callback<Response> mResultCallback = new Callback<Response>() {
        @Override
        public void onResponse(retrofit.Response<Response> response, Retrofit retrofit) {

            mGoogleMap.clear();
            // レスポンスからResultのリストを取得
            List<Result> results = response.body().getResults();
            // Resultの数だけピンを立てる
            for(Result r : results) {
                Location location = r.getGeometry().getLocation();
                LatLng latLng = new LatLng(location.getLat(), location.getLng());
                String name = r.getName();

                Log.d("name",r.getName());

                mGoogleMap.addMarker(new MarkerOptions().position(latLng).title(name));
            }
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mCurrentLatLng, 15));

        }

        @Override
        public void onFailure(Throwable t) {
            t.printStackTrace();
        }
    };

    /*検索ボタンをクリックした時に、テキストに打たれた内容をGoogleMapで検索して、
    　エミュレータ上のマップに表示する*/
    public void search(View v) {


    }

    public void random(View v) {


        Random random = new Random();
        int number;
        number = random.nextInt(9);

        if (number == 0) {
            textView.setText("オムライス");
        } else if (number == 1) {
            textView.setText("うどん");
        } else if (number == 2) {
            textView.setText("カレー");
        } else if (number == 3) {
            textView.setText("焼肉");
        } else if (number == 4) {
            textView.setText("鍋");
        } else if (number == 5) {
            textView.setText("ラーメン");
        } else if (number == 6) {
            textView.setText("海鮮");
        } else if (number == 7) {
            textView.setText("お好み焼き");
        } else if (number == 8) {
            textView.setText("串カツ");
        } else if (number == 9) {
            textView.setText("とんかつ");
        }


    }

    public void back(View v) {
        finish();
    }



}
