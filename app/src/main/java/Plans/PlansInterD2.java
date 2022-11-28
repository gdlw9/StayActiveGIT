package Plans;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class PlansInterD2 extends Fragment {

    public static PlansInterD2 newInstance() {
        PlansInterD2 fragment = new PlansInterD2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_plans_inter_d2, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "sred","2",getActivity(),v);

        orderData.execute("");

        return v;
    }
}