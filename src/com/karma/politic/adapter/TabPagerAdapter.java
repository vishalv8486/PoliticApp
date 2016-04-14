package com.karma.politic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.karma.politic.fragment.MinistryFragment;
import com.karma.politic.fragment.MlaFragment;
import com.karma.politic.fragment.MlaFragment;
import com.karma.politic.fragment.MpFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

	public TabPagerAdapter(FragmentManager fm) {
		super(fm);

	}

	public Fragment getItem(int index) {
		switch (index) {

		case 0:

			return new MpFragment();

		case 1:
			return new MlaFragment();
		case 2:
			return new MinistryFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
