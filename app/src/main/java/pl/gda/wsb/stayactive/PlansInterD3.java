package pl.gda.wsb.stayactive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlansInterD3 extends Fragment {

    public static PlansInterD3 newInstance() {
        PlansInterD3 fragment = new PlansInterD3();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_plans_inter_d3, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "sred","3",getActivity(),v);

        orderData.execute("");

        return v;
    }
}