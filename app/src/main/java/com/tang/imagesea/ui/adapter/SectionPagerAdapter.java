package com.tang.imagesea.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tang.imagesea.ui.HomeActivity;
import com.tang.imagesea.ui.PhotosFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the
 * sections/tabs/pages.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position==0){
            return PhotosFragment.newInstance("latest");
        }else if(position==1){
            return PhotosFragment.newInstance("latest");
        }
        return HomeActivity.PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Photo";
            case 1:
                return "Collection";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
