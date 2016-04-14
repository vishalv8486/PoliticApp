package com.karma.politic.fragment;

import java.util.ArrayList;
import java.util.List;

import com.karma.politic.DevendraPersonalInfo;
import com.karma.politic.MpItem;
import com.karma.politic.PersonalInfo;
import com.karma.politic.R;
import com.karma.politic.VinodPersonalInfo;
import com.karma.politic.adapter.MpAdapter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MpFragment extends Fragment  {

	List<MpItem> mpItems;

	public MpFragment() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		// setContentView(R.layout.fragment_mp);

		mpItems = new ArrayList<MpItem>();
		Resources resources = getResources();

		mpItems.add(new MpItem(getString(R.string.mpName1),
				getString(R.string.mpconstituency1),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.narendramodi),
				getString(R.string.party)));

		mpItems.add(new MpItem(getString(R.string.mpName2),
				getString(R.string.mpconstituency2),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.nitin),
				getString(R.string.party)));

		mpItems.add(new MpItem(getString(R.string.mpName3),
				getString(R.string.mpconstituency3),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.sureshprabhu),
				getString(R.string.party)));

		mpItems.add(new MpItem(getString(R.string.mpName4),
				getString(R.string.mpconstituency3),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.smriti),
				getString(R.string.party)));

		mpItems.add(new MpItem(getString(R.string.mpName5),
				getString(R.string.mpconstituency5),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.arunjaitley),
				getString(R.string.party)));

		mpItems.add(new MpItem(getString(R.string.mpName6),
				getString(R.string.mpconstituency6),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.sushma),
				getString(R.string.party)));

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle) {

		View rootView = inflater
				.inflate(R.layout.fragment_mp, container, false);
		// if get error see this line........
		MpAdapter mpAdapter = new MpAdapter(getActivity(), mpItems);

		ListView listView = (ListView) rootView.findViewById(R.id.listMpInfo);
		listView.setAdapter(mpAdapter);

		return rootView;

	}


}
