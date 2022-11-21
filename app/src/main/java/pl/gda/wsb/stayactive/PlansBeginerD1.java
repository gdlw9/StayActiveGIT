package pl.gda.wsb.stayactive;


import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PlansBeginerD1 extends Fragment {

    public static PlansBeginerD1 newInstance() {
        PlansBeginerD1 fragment = new PlansBeginerD1();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_beginer_d1, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "pocz","1",getActivity(),v);
        orderData.execute("");

        return v;
    }






}