package Plans;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import pl.gda.wsb.stayactive.databinding.ActivityPlansInterBinding;
import pl.gda.wsb.stayactive.ui.main.SectionsPagerAdapter3DaysInter;


public class PlansInter extends AppCompatActivity {

    private ActivityPlansInterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlansInterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter3DaysInter sectionsPagerAdapter = new SectionsPagerAdapter3DaysInter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}