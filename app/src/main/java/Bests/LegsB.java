package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class LegsB extends Fragment {

    public static LegsB newInstance() {
        LegsB fragment = new LegsB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_legs_b, container, false);
        Spinner spinner = new Spinner("legsB",getActivity(),v);
        return v;
    }
}