package Exc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.gda.wsb.stayactive.R;

public class Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exc_list);

        SyncDataExc orderData = new SyncDataExc("back", this);
        orderData.execute("");

    }
}

