package Plans;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;


public class PlansAdvD1 extends Fragment {

    public static PlansAdvD1 newInstance() {
        PlansAdvD1 fragment = new PlansAdvD1();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_adv_d, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "zaaw","1",getActivity(),v);

        orderData.execute("");
        return v;
    }
}