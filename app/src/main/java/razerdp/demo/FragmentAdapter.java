package razerdp.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mIds;
    private List<String> mTitles;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        mIds = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mIds.get(position);
    }

    @Override
    public int getCount() {
        return mIds.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
