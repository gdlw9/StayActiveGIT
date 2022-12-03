package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import pl.gda.wsb.stayactive.R;


public class ChestB extends Fragment  {

    public static ChestB newInstance() {
        ChestB fragment = new ChestB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chest_b, container, false);
        Spinner spinner = new Spinner("abdomenB",getActivity(),v);
        return v;
    }


}