package com.karma.politic.fragment;

import java.util.ArrayList;
import java.util.List;

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

import com.karma.politic.DevendraPersonalInfo;
import com.karma.politic.DevendraPersonalNew;
import com.karma.politic.MlaItem;
import com.karma.politic.R;
import com.karma.politic.VinodPersonal;
import com.karma.politic.VinodPersonalInfo;
import com.karma.politic.adapter.MlaAdapter;

public class MlaFragment extends Fragment {

	private List<MlaItem> mlaItems;
	private MlaAdapter mlaAdapter;
	ListView listView;

	public MlaFragment() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		// setContentView(R.layout.fragment_mla);

		mlaItems = new ArrayList<MlaItem>();
		Resources resources = getResources();

		mlaItems.add(new MlaItem(getString(R.string.mlaName1),
				getString(R.string.mlaconstituency1),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.devendra),
				getString(R.string.party)));

		mlaItems.add(new MlaItem(getString(R.string.mlaName2),
				getString(R.string.mlaconstituency2),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.vtavade),
				getString(R.string.party)));

		mlaItems.add(new MlaItem(getString(R.string.mlaName3),
				getString(R.string.mlaconstituency3),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.eknath),
				getString(R.string.party)));

		mlaItems.add(new MlaItem(getString(R.string.mlaName4),
				getString(R.string.mlaconstituency3),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.sudhir),
				getString(R.string.party)));

		mlaItems.add(new MlaItem(getString(R.string.mlaName5),
				getString(R.string.mlaconstituency5),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.girish),
				getString(R.string.party)));

		mlaItems.add(new MlaItem(getString(R.string.mlaName6),
				getString(R.string.mlaconstituency6),
				getString(R.string.duration), getString(R.string.datetime),
				resources.getDrawable(R.drawable.eknathshine),
				getString(R.string.party)));

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle) {
		

		View rootView = inflater.inflate(R.layout.fragment_mla, container,
				false);
		// if get error see this line........
		MlaAdapter mlaAdapter = new MlaAdapter(getActivity(), mlaItems);

		ListView listMla = (ListView) rootView.findViewById(R.id.listMlaInfo);
		listMla.setAdapter(mlaAdapter);

		listMla.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				switch (position) {
				case 0:
					Intent intent = new Intent(getActivity(),
							DevendraPersonalNew.class);
					startActivity(intent);

					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), VinodPersonal.class);
					startActivity(intent1);

					break;

				default:
					break;
				}

			}
		});

		return rootView;

	}

}
