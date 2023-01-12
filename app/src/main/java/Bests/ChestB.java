package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class ChestB extends Fragment  {

    public static ChestB newInstance() {
        ChestB fragment = new ChestB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_list, container, false);
        Spinner spinner = new Spinner("chestB",getActivity(),v);
        return v;
    }


}