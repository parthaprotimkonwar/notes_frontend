package com.notes.ui.activity.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private FragmentTabHost fragmentTabHost;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentTabHost = new FragmentTabHost(getActivity());

        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), 10);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("All Courses").setIndicator("All Courses"), AllCoursesFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("My Courses").setIndicator("My Courses"), MyCoursesFragment.class, null);
        return fragmentTabHost;
    }
}
