package pl.gda.wsb.stayactive;

import android.annotation.SuppressLint;


import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.StrictMode;

import android.text.format.Formatter;
import android.util.Log;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ConSQL {

    private Connection con;




    @SuppressLint("NewApi")
    public Connection conclass() {
        String ip = "192.168.0.113", port = "52763", db = "fitness", username = "sa", password = "1234";
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String connectURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectURL = "jdbc:jtds:sqlserver://" + ip + ":"
                    + port + ";databasename=" + db + ";user=" + username + ";"+"password=" + password + ";";
            con = DriverManager.getConnection(connectURL);
        } catch (Exception e) {
            Log.e("Error :", e.getMessage());
        }
        return con;
    }
}
