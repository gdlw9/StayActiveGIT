package pl.gda.wsb.stayactive.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Plans.PlansAdvD1;
import Plans.PlansAdvD2;
import Plans.PlansAdvD3;
import Plans.PlansAdvD4;
import pl.gda.wsb.stayactive.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter4DaysAdv extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Atab_text_1, R.string.Atab_text_2,R.string.Atab_text_3,R.string.Atab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter4DaysAdv(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position)
        {
            case 0:
                fragment = PlansAdvD1.newInstance();
                break;
            case 1:
                fragment = PlansAdvD2.newInstance();
                break;
            case 2:
                fragment = PlansAdvD3.newInstance();
                break;
            case 3:
                fragment = PlansAdvD4.newInstance();
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
        return 4;
    }
}