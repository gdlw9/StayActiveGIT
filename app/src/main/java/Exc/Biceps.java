package Exc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.gda.wsb.stayactive.R;

public class Biceps extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        SyncDataExc orderData = new SyncDataExc("biceps",this,this);
        orderData.execute("");

    }


}