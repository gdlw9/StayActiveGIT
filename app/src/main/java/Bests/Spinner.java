package Bests;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


import Exc.Adapter;
import pl.gda.wsb.stayactive.ConSQL;
import pl.gda.wsb.stayactive.R;

public class Spinner implements AdapterView.OnItemSelectedListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {

//DECLARE VARIABLES
    private android.widget.Spinner spinner;
    private ConSQL connectionClass;
    private String table,exc;
    private Context context;
    private Activity activity;
    private EditText best,reps,datePick;
    private View v;
    private Button btnupdate;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener date;



    private ArrayList<String> data= new ArrayList<>();




    public Spinner(String table, Activity activity, View v) {
//DEFINE CONSTRUCTOR
        this.table=table;
        this.activity = activity;
        this.context=activity.getApplicationContext();
        this.v=v;
        this.connectionClass=new ConSQL();

//DECLARE COMPONENTS
        this.best=v.findViewById(R.id.best);
        this.reps=v.findViewById(R.id.reps);
        this.btnupdate=v.findViewById(R.id.update);
        this.spinner=v.findViewById(R.id.spinner);
        this.datePick=v.findViewById(R.id.dp);

// SPINNER
        FillSpinner();
        this.spinner.setOnItemSelectedListener(this);

//CALENDAR
        this.calendar=Calendar.getInstance();
        date=this::onDateSet;
        this.datePick.setOnClickListener(this::onClick);

//BUTTON UPDATE
        this.btnupdate.setOnClickListener(this::onClick);
    }

    public void updateCalendar(){
        String Format="dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.GERMAN);
        this.datePick.setText(sdf.format(this.calendar.getTime()));
    }

    public void FillSpinner(){
        Connection conn=connectionClass.conclass();
        try{
            if(conn!=null) {
                String query = "SELECT * FROM "+table;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                ArrayList<String> data= new ArrayList<>();

                while(rs.next()){
                    String exc=rs.getString("cwi");
                    data.add(exc);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(context,R.layout.color_spinner_layout,data);
                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
                spinner.setAdapter(arrayAdapter);

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.exc= parent.getItemAtPosition(position).toString();
        Connection conn=connectionClass.conclass();
        try {
            if (conn != null) {
                String query = "SELECT * FROM "+table+" WHERE cwi='"+exc+"'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    best.setText(rs.getString("best"));
                    reps.setText(rs.getString("powtorzenia"));
                    datePick.setText(rs.getString("data"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //OnClickListen for update button and DatePick field
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.update:
                Connection conn = connectionClass.conclass();
                if (reps.getText().toString().matches("") || datePick.getText().toString().matches(""))
                    Toast.makeText(context, "Pola: 'Powtórzenia' i 'Data' są wymagane!", Toast.LENGTH_LONG).show();
                else {
                    try {
                        String query = "UPDATE " + table + " SET best = '"
                                + best.getText().toString() + "' , powtorzenia = '"
                                + reps.getText().toString() + "' , data = '"
                                + datePick.getText().toString() + "' WHERE cwi='" + exc + "'";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(query);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                    Toast.makeText(context, "Ćwiczenie zaktualizowane", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.dp:
                 new DatePickerDialog(
                         activity,
                         this.date,
                         calendar.get(Calendar.YEAR),
                         calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                         .show();
                break;

        }

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.calendar.set(Calendar.YEAR, year);
        this.calendar.set(Calendar.MONTH, month);
        this.calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        updateCalendar();
    }





}
