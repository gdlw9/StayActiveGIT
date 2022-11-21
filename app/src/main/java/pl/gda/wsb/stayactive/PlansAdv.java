package pl.gda.wsb.stayactive;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import pl.gda.wsb.stayactive.databinding.ActivityPlansAdvBinding;
import pl.gda.wsb.stayactive.ui.main.SectionsPagerAdapter4DAYS;

public class PlansAdv extends AppCompatActivity {

    private ActivityPlansAdvBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlansAdvBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter4DAYS sectionsPagerAdapter = new SectionsPagerAdapter4DAYS(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);



    }
}