package com.karma.politic.fragment;

import java.util.ArrayList;
import java.util.List;
import com.karma.politic.MinistryItem;
import com.karma.politic.R;
import com.karma.politic.adapter.MinistryAdapter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MinistryFragment extends Fragment {

	List<MinistryItem> ministryItems;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		ministryItems = new ArrayList<MinistryItem>();
		Resources resources = getResources();

		ministryItems.add(new MinistryItem(getString(R.string.mpName1),
				getString(R.string.post1),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.narendramodi),
				getString(R.string.party)));

		ministryItems.add(new MinistryItem(getString(R.string.mpName2),
				getString(R.string.post2),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.nitin),
				getString(R.string.party)));

		ministryItems.add(new MinistryItem(getString(R.string.mpName3),
				getString(R.string.post3),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.sureshprabhu),
				getString(R.string.party)));

		ministryItems.add(new MinistryItem(getString(R.string.mpName4),
				getString(R.string.post4),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.smriti),
				getString(R.string.party)));

		ministryItems.add(new MinistryItem(getString(R.string.mpName5),
				getString(R.string.post6),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.arunjaitley),
				getString(R.string.party)));

		ministryItems.add(new MinistryItem(getString(R.string.mpName6),
				getString(R.string.post5),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.sushma),
				getString(R.string.party)));

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle) {

		View rootView = inflater.inflate(R.layout.fragment_ministry, container,
				false);
		// if get error see this line........

		MinistryAdapter adapter = new MinistryAdapter(getActivity(),
				ministryItems);

		ListView listView = (ListView) rootView
				.findViewById(R.id.listViewMinistry);
		listView.setAdapter(adapter);

		return rootView;

	}

}
