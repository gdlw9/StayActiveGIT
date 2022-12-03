package Bests;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Plans.PlansBeginerD1;
import pl.gda.wsb.stayactive.R;


public class AbdomenB extends Fragment {

    public static AbdomenB newInstance() {
        AbdomenB fragment = new AbdomenB();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_abdomen_b, container, false);
        Spinner spinner = new Spinner("abdomenB",getActivity(),v);
        return v;
    }
}