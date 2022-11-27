package pl.gda.wsb.stayactive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SyncDataPlans extends AsyncTask<String,String,String> implements RecyclerViewInterface
{
    private ArrayList<PlansModelClass> arrayList;
    private PlansAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean success = false;
    private ConSQL connectionClass;
    private String table,day;
    Context context;
    Activity activity;




    public SyncDataPlans(String table, String day, Activity activity, View v) {
        this.table = table;
        this.day=day;
        this.activity=activity;
        this.context= activity.getApplicationContext();


        recyclerView=v.findViewById(R.id.plansrecyclerview);
        recyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(mLayoutManager);
        connectionClass=new ConSQL();
        arrayList=new ArrayList<>();
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
                String query="Select * FROM "+table+" WHERE dzien = "+day;
                Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);



                if(rs!=null) {
                    while(rs.next())
                    {

                        try{

                            arrayList.add(new PlansModelClass(rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5)));
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
            adapter=new PlansAdapter(arrayList,context,this);
            recyclerView.setAdapter(adapter);
        }

    }
    public void changeActivity(Class c){
        Intent intent = new Intent(activity,c);

        activity.startActivity(intent);
    }

    @Override
    public void OnItemClick(int position) {
        switch (arrayList.get(position).mscl){
            case "Klatka piersiowa":
                changeActivity(Chest.class);
                break;
            case "Plecy":
                changeActivity(Back.class);
                break;
            case "Barki":
                changeActivity(Arms.class);
                break;
            case "Biceps":
                changeActivity(Biceps.class);
                break;
            case "Triceps":
                changeActivity(Triceps.class);
                break;
            case "Brzuch":
                changeActivity(Abdomen.class);
                break;
            case "Nogi":
                changeActivity(Legs.class);
                break;
            default:
                break;


        }

    }
}
