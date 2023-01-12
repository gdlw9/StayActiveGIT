package Plans;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import pl.gda.wsb.stayactive.ui.main.SectionsPagerAdapter3DaysBeg;
import pl.gda.wsb.stayactive.databinding.ActivityPlansBeginerBinding;

public class PlansBeginer extends AppCompatActivity {

    private ActivityPlansBeginerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityPlansBeginerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter3DaysBeg sectionsPagerAdapter = new SectionsPagerAdapter3DaysBeg(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}