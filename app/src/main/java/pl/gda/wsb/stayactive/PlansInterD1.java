package pl.gda.wsb.stayactive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PlansInterD1 extends Fragment {



    public static PlansInterD1 newInstance() {
        PlansInterD1 fragment = new PlansInterD1();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_inter_d1, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "sred","1",getActivity(),v);

        orderData.execute("");

        return v;
    }










}