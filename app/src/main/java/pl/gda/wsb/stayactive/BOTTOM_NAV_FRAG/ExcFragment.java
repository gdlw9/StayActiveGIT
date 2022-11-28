package pl.gda.wsb.stayactive.BOTTOM_NAV_FRAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import Exc.Abdomen;
import Exc.Arms;
import Exc.Back;
import Exc.Biceps;
import Exc.Chest;
import Exc.Legs;
import pl.gda.wsb.stayactive.R;
import Exc.Triceps;


public class ExcFragment extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_exc, container, false);


        ImageButton imageButton =view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this::onClick);
        ImageButton imageButton2=view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(this::onClick);
        ImageButton imageButton3=view.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this::onClick);
        ImageButton imageButton4=view.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(this::onClick);
        ImageButton imageButton5=view.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(this::onClick);
        ImageButton imageButton6=view.findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(this::onClick);
        ImageButton imageButton7=view.findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(this::onClick);



        return view;
    }
    public void changeActivity(Class c){
        Intent intent = new Intent(getActivity(),c);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                changeActivity(Chest.class);
                break;
            case R.id.imageButton2:
                changeActivity(Back.class);
                break;
            case R.id.imageButton3:
                changeActivity(Arms.class);
                break;
            case R.id.imageButton4:
                changeActivity(Biceps.class);
                break;
            case R.id.imageButton5:
                changeActivity(Triceps.class);
                break;
            case R.id.imageButton6:
                changeActivity(Abdomen.class);
                break;
            case R.id.imageButton7:
                changeActivity(Legs.class);
                break;
            default:
                break;
        }
    }

}

