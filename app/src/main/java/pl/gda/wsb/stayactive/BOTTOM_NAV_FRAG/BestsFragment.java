package pl.gda.wsb.stayactive.BOTTOM_NAV_FRAG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import pl.gda.wsb.stayactive.R;
import pl.gda.wsb.stayactive.databinding.FragmentBestsBinding;
import pl.gda.wsb.stayactive.ui.main.SectionsPagerAdapterBests;


public class BestsFragment extends Fragment {

    private FragmentBestsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bests, container, false);

        binding = FragmentBestsBinding.inflate(getLayoutInflater());
        ViewPager viewPager = (ViewPager)v.findViewById(R.id.view_pager);
        viewPager.setAdapter(new SectionsPagerAdapterBests(getContext(),getParentFragmentManager()));
        TabLayout tabs = (TabLayout) v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        return v;
    }
}