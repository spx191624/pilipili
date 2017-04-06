package nataya.pilipili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;


import java.util.List;

import nataya.pilipili.view.BaseFragment;

/**
 * Created by 191624 on 2017/3/21.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private final List<BaseFragment> fragments;
    private final String[] titles;
    private FragmentManager fm;
    private FragmentTransaction mCurTransaction = null;

    public MyViewPagerAdapter(FragmentManager supportFragmentManager, List<BaseFragment> fragments, String[] titles) {
        super(supportFragmentManager);
        fm = supportFragmentManager;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mCurTransaction == null) {
            mCurTransaction = fm.beginTransaction();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }



}
