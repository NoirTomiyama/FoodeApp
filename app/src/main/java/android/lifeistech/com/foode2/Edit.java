package android.lifeistech.com.foode2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void decision(View v){
        Intent intent = new Intent(this,MapsActivity_Select.class);
        startActivity(intent);

    }
}
