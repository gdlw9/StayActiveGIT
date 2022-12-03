package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class ArmsB extends Fragment {

    public static ArmsB newInstance() {
        ArmsB fragment = new ArmsB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_arms_b, container, false);
        Spinner spinner = new Spinner("armsB",getActivity(),v);
        return v;
    }
}