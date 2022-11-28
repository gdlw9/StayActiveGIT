package pl.gda.wsb.stayactive.BOTTOM_NAV_FRAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import Plans.PlansAdv;
import Plans.PlansBeginer;
import Plans.PlansInter;
import pl.gda.wsb.stayactive.R;


public class PlansFragment extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_plans, container, false);


        ImageButton imageButton =view.findViewById(R.id.imageButton9);
        imageButton.setOnClickListener(this::onClick);
        ImageButton imageButton2=view.findViewById(R.id.imageButton10);
        imageButton2.setOnClickListener(this::onClick);
        ImageButton imageButton3=view.findViewById(R.id.imageButton11);
        imageButton3.setOnClickListener(this::onClick);




        return view;
    }
    public void changeActivity(Class c){
        Intent intent = new Intent(getActivity(),c);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton9:
                changeActivity(PlansBeginer.class);
                break;
            case R.id.imageButton10:
                changeActivity(PlansInter.class);
                break;
            case R.id.imageButton11:
                changeActivity(PlansAdv.class);
                break;
            default:
                break;
        }
    }

}