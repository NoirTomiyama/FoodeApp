package android.lifeistech.com.foode2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

public class MapsActivity_10 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_10);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        textView = (TextView)findViewById(R.id.textView);



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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }


    /*検索ボタンをクリックした時に、テキストに打たれた内容をGoogleMapで検索して、
    　エミュレータ上のマップに表示する*/
    public void search(View v){

        /*TextViewに表示された内容をGoogleAPIのプレイス検索のコマンドとして
        用意されている、周辺検索リクエストのkeywardパラメータに関連づける
        コードをこのsearchメソッドに書く*/

    }

    public void random(View v){



          Random random = new Random();
          int number;
          number = random.nextInt(9);

            if (number==0){
                textView.setText("オムライス");
            }else if (number ==1) {
                textView.setText("うどん");
            }else if (number==2) {
                textView.setText("カレー");
            }else if (number==3) {
                textView.setText("焼肉");
            }else if (number==4) {
                textView.setText("鍋");
            }else if (number==5) {
                textView.setText("ラーメン");
            }else if (number==6) {
                textView.setText("海鮮");
            }else if (number==7) {
                textView.setText("お好み焼き");
            }else if (number==8) {
                textView.setText("串カツ");
            } else if (number == 9) {
                textView.setText("とんかつ");
            }



    }

    public void back(View v){
        finish();
    }





}
