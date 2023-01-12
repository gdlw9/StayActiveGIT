package Plans;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Exc.Abdomen;
import Exc.Arms;
import Exc.Back;
import Exc.Biceps;
import Exc.Chest;
import pl.gda.wsb.stayactive.ConSQL;
import Exc.Legs;
import pl.gda.wsb.stayactive.R;
import Exc.Triceps;

public class SyncDataPlans extends AsyncTask<String,Void,String> implements RecyclerViewInterface
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

    private String msg = "Internet Connection Error";



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
                    msg="Success";
                    success=true;
                }else{
                    msg="No data found";
                    success=false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();

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
