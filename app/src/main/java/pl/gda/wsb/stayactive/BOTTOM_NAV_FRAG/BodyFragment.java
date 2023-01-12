package pl.gda.wsb.stayactive.BOTTOM_NAV_FRAG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import pl.gda.wsb.stayactive.BodyHandler;
import pl.gda.wsb.stayactive.R;


public class BodyFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_body, container, false);
        BodyHandler bodyHandler = new BodyHandler(getActivity(),v);
        return v;
    }
}