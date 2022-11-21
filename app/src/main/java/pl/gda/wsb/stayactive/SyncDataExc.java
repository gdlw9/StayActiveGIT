package pl.gda.wsb.stayactive;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SyncDataExc extends AsyncTask<String,String,String>
{
    private ArrayList<ModelClass> arrayList;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean success = false;
    private ConSQL connectionClass;
    private String table;
    Context context;
    Activity activity;




    public SyncDataExc(String table,Context context, Activity activity) {
        this.table = table;
        this.context=context;
        this.activity=activity;


        recyclerView=activity.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        connectionClass=new ConSQL();
        arrayList=new ArrayList<ModelClass>();
    }

    String msg = "Internet/DB_Credentials/Windows_FireWall_TurnOn Error, " +
            "See Android Monitor in the bottom for details.";


    @Override
    protected String doInBackground(String... strings) {
        try
        {
            Connection conn=connectionClass.conclass();
            if(conn==null) { success=false; }
            else {
                String query="Select * FROM "+table;
                Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                if(rs!=null) {
                    while(rs.next())
                    {
                        try{

                            arrayList.add(new ModelClass(rs.getString("cwiczenie"),
                                    "MIĘSNIE PRACUJĄCE:\n"+rs.getString("miesnie_prac"),
                                    "WYKONANIE:\n"+rs.getString("wykonanie"),
                                    rs.getBytes("zdj"),
                                    false));
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
            adapter=new Adapter(arrayList,context);
            recyclerView.setAdapter(adapter);
        }

    }
}
