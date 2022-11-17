package pl.gda.wsb.stayactive;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Chest extends AppCompatActivity {

    private ArrayList<ModelClass> arrayList;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean success = false;
    private ConSQL connectionClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        connectionClass=new ConSQL();
        arrayList=new ArrayList<ModelClass>();

        SyncData orderData = new SyncData();
        orderData.execute("");

    }

    private class SyncData extends AsyncTask<String,String,String>
    {

        String msg = "Internet/DB_Credentials/Windows_FireWall_TurnOn Error, " +
                "See Android Monitor in the bottom for details.";


        @Override
        protected String doInBackground(String... strings) {
            try
            {
                Connection conn=connectionClass.conclass();
                if(conn==null) { success=false; }
                else {
                    String query="Select * FROM chest";
                    Statement stmt = conn.createStatement();
                    ResultSet rs=stmt.executeQuery(query);
                    if(rs!=null) {
                        while(rs.next())
                        {
                            try{
                                arrayList.add(new ModelClass(rs.getString("cwiczenie"),
                                        "MIĘSNIE PRACUJĄCE:\n"+rs.getString("miesnie_prac"),
                                        "WYKONANIE:\n"+rs.getString("wykonanie"),R.drawable.brz,false));
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        msg="Found";
                        success=true;
                    }else{
                        msg="no data found";
                        success=false;
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
                Writer writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                msg = writer.toString();
                success=false;
            }
            return msg;
        }
        protected void onPostExecute(String msg)
        {
            if(success) {
                adapter=new Adapter(arrayList,Chest.this);
                recyclerView.setAdapter(adapter);
            }

        }
    }
}