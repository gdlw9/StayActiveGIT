package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class BicepsB extends Fragment {

    public static BicepsB newInstance() {
        BicepsB fragment = new BicepsB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_biceps_b, container, false);
        Spinner spinner = new Spinner("bicepsB",getActivity(),v);
        return v;
    }
}