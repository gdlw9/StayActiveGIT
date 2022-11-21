package pl.gda.wsb.stayactive.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import pl.gda.wsb.stayactive.PlansInter;
import pl.gda.wsb.stayactive.PlansInterD1;
import pl.gda.wsb.stayactive.PlansInterD2;
import pl.gda.wsb.stayactive.PlansInterD3;
import pl.gda.wsb.stayactive.R;


public class SectionsPagerAdapter3DaysInter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter3DaysInter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position)
        {
            case 0:
                fragment = PlansInterD1.newInstance();
                break;
            case 1:
                fragment = PlansInterD2.newInstance();
                break;
            case 2:
                fragment = PlansInterD3.newInstance();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}