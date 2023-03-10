package Plans;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.gda.wsb.stayactive.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlansAdvD2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlansAdvD2 extends Fragment {

    public static PlansAdvD2 newInstance() {
        PlansAdvD2 fragment = new PlansAdvD2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plans_adv_d, container, false);

        SyncDataPlans orderData = new SyncDataPlans(
                "zaaw","2",getActivity(),v);

        orderData.execute("");
        return v;
    }
}