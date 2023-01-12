package pl.gda.wsb.stayactive;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BodyHandler implements View.OnClickListener {
    private  Button btnWeight,btnHeight,btnArm,btnChest,btnStomach,btnHip,btnLeg,btnCalv;
    private  EditText EtWeight,EtHeight,EtArm,EtChest,EtStomach,EtHip,EtLeg,EtCalv;
    private View v;
    private Context context;
    private Activity activity;
    private ConSQL connectionClass;
    private ArrayList<EditText> editTextArrayList= new ArrayList<>();

    public BodyHandler(Activity activity,View v){
        this.v=v;
        this.activity=activity;
        this.context=activity.getApplicationContext();
        this.connectionClass=new ConSQL();


        //EditText declaration
        EtWeight=v.findViewById(R.id.weight);
        EtHeight=v.findViewById(R.id.height);
        EtArm=v.findViewById(R.id.arm);
        EtChest=v.findViewById(R.id.chest);
        EtStomach=v.findViewById(R.id.stomach);
        EtHip=v.findViewById(R.id.hips);
        EtLeg=v.findViewById(R.id.leg);
        EtCalv=v.findViewById(R.id.calv);




        //Buttons declaration && assignment of OnClick
        btnWeight=v.findViewById(R.id.btnweight);
        btnWeight.setOnClickListener(this);

        btnHeight=v.findViewById(R.id.btnheight);
        btnHeight.setOnClickListener(this);

        btnArm=v.findViewById(R.id.btnarm);
        btnArm.setOnClickListener(this);

        btnChest=v.findViewById(R.id.btnchest);
        btnChest.setOnClickListener(this);

        btnStomach=v.findViewById(R.id.btnstomach);
        btnStomach.setOnClickListener(this);

        btnHip=v.findViewById(R.id.btnhips);
        btnHip.setOnClickListener(this);

        btnLeg=v.findViewById(R.id.btnleg);
        btnLeg.setOnClickListener(this);

        btnCalv=v.findViewById(R.id.btncalv);
        btnCalv.setOnClickListener(this);

        //EditText to Array
        editTextArrayList.add(EtWeight);
        editTextArrayList.add(EtHeight);
        editTextArrayList.add(EtArm);
        editTextArrayList.add(EtChest);
        editTextArrayList.add(EtStomach);
        editTextArrayList.add(EtHip);
        editTextArrayList.add(EtLeg);
        editTextArrayList.add(EtCalv);



        FillMeasurements();


    }



    public void FillMeasurements(){
        Connection conn=connectionClass.conclass();
        int i=0;
        try {
            if (conn != null) {
                String query = "SELECT * FROM body";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                ArrayList<String> arrayList = new ArrayList<>();
                while(rs.next()){
                    String measurments=rs.getString("pomiar");
                    arrayList.add(measurments);
                }
                for (EditText e : editTextArrayList){
                    e.setText(arrayList.get(i));
                    i++;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnweight:
                 Connection conn = connectionClass.conclass();
                if (EtWeight.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtWeight.getText().toString() + "' WHERE partia ='waga'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Waga zaktualizowana", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnheight:
                conn = connectionClass.conclass();
                if (EtHeight.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtHeight.getText().toString() + "' WHERE partia ='wzrost'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Wzrost zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnarm:
                conn = connectionClass.conclass();
                if (EtArm.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtArm.getText().toString() + "' WHERE partia ='ramie'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar ramienia zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.btnchest:
                conn = connectionClass.conclass();
                if (EtChest.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtChest.getText().toString() + "' WHERE partia ='klatka_p'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar klatki piersiowej zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnstomach:
                conn = connectionClass.conclass();
                if (EtStomach.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtStomach.getText().toString() + "' WHERE partia ='talia'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar talii zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.btnhips:
                conn = connectionClass.conclass();
                if (EtHip.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtHip.getText().toString() + "' WHERE partia ='biodra'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar biodra zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnleg:
                conn = connectionClass.conclass();
                if (EtLeg.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtLeg.getText().toString() + "' WHERE partia ='udo'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar uda zaktualizowany", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.btncalv:
                conn = connectionClass.conclass();
                if (EtCalv.getText().toString().matches(""))
                    Toast.makeText(context, "Uzupełnij pomiar!", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        String query = "UPDATE body SET pomiar = '" + EtCalv.getText().toString() + "' WHERE partia ='lydka'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Pomiar łydki zaktualizowany", Toast.LENGTH_SHORT).show();

                    break;
                }

        }
    }
}
