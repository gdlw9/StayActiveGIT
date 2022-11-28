package Plans;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pl.gda.wsb.stayactive.ui.main.SectionsPagerAdapter3DaysBeginer;
import pl.gda.wsb.stayactive.databinding.ActivityPlansBeginerBinding;

public class PlansBeginer extends AppCompatActivity {

    private ActivityPlansBeginerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityPlansBeginerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter3DaysBeginer sectionsPagerAdapter = new SectionsPagerAdapter3DaysBeginer(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}