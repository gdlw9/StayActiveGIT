package pl.gda.wsb.stayactive;


import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class PlansBeginerD3 extends Fragment {

    public static PlansBeginerD3 newInstance() {
        PlansBeginerD3 fragment = new PlansBeginerD3();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_beginer_d3, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "pocz","3",getActivity(),v);

        orderData.execute("");
        return v;
    }


}