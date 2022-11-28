package Plans;


import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class PlansBeginerD2 extends Fragment {


    public static PlansBeginerD2 newInstance() {
        PlansBeginerD2 fragment = new PlansBeginerD2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_beginer_d2, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "pocz","2",getActivity(),v);

        orderData.execute("");
        return v;
    }




}