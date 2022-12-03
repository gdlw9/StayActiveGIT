package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class TricepsB extends Fragment {

    public static TricepsB newInstance() {
        TricepsB fragment = new TricepsB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_triceps_b, container, false);
        Spinner spinner = new Spinner("tricepsB",getActivity(),v);
        return v;
    }
}