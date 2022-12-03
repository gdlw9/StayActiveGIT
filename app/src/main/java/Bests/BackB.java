package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class BackB extends Fragment {

    public static BackB newInstance() {
        BackB fragment = new BackB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_back_b, container, false);
        Spinner spinner = new Spinner("backB",getActivity(),v);
        return v;
    }
}