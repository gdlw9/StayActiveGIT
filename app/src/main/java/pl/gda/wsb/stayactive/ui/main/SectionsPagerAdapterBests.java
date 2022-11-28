package pl.gda.wsb.stayactive.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Bests.AbdomenB;
import Bests.ArmsB;
import Bests.BackB;
import Bests.BicepsB;
import Bests.ChestB;

import Bests.LegsB;
import Bests.TricepsB;
import Exc.Legs;
import Exc.Triceps;
import pl.gda.wsb.stayactive.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterBests extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Bests_text_1, R.string.Bests_text_2,R.string.Bests_text_3,
            R.string.Bests_text_4, R.string.Bests_text_5,R.string.Bests_text_6,R.string.Bests_text_7};
    private final Context mContext;

    public SectionsPagerAdapterBests(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position)
        {
            case 0:
                fragment = ChestB.newInstance();
                break;
            case 1:
                fragment = BackB.newInstance();
                break;
            case 2:
                fragment = ArmsB.newInstance();
                break;
            case 3:
                fragment = BicepsB.newInstance();
                break;
            case 4:
                fragment = TricepsB.newInstance();
                break;
            case 5:
                fragment = AbdomenB.newInstance();
                break;
            case 6:
                fragment = LegsB.newInstance();
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

        return 7;
    }
}