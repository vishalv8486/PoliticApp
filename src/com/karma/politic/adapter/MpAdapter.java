package com.karma.politic.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karma.politic.MpItem;
import com.karma.politic.PersonalInfo;
import com.karma.politic.R;

public class MpAdapter extends BaseAdapter {

	List<MpItem> mpItems;
	Context context;

	public MpAdapter(Context context, List<MpItem> mpItems) {
		this.mpItems = mpItems;
		this.context = context;
		LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mpItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mpItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder viewHolder;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {

			convertView = inflater.inflate(R.layout.list_mp, null);
			viewHolder = new ViewHolder();

			viewHolder.imageMp = (ImageView) convertView.findViewById(R.id.mpImage);
			viewHolder.txtDateTime = (TextView) convertView.findViewById(R.id.textDateTime);
			viewHolder.txtMpName = (TextView) convertView.findViewById(R.id.textMpName);
			viewHolder.txtMpConstituency = (TextView) convertView.findViewById(R.id.textConstituency);
			viewHolder.txtPoliticalParty = (TextView) convertView.findViewById(R.id.textParty);
			viewHolder.txtDuration = (TextView) convertView.findViewById(R.id.textDuration);
			viewHolder.btnViewDetail = (ImageView) convertView.findViewById(R.id.btnViewDetail);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();

		}

		MpItem mpItem = mpItems.get(position);
		viewHolder.txtDateTime.setText(mpItem.getDateTime());
		viewHolder.imageMp.setImageDrawable(mpItem.getMpImage());
		viewHolder.txtMpName.setText(mpItem.getMpName());
		viewHolder.txtMpConstituency.setText(mpItem.getMpConstituency());
		viewHolder.txtDuration.setText(mpItem.getMpDuration());
		viewHolder.txtPoliticalParty.setText(mpItem.getMpParty());
		viewHolder.btnViewDetail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Toast.makeText(context, "YOu clicked on View
				// Details",Toast.LENGTH_SHORT).show();

			}
		});

		return convertView;
	}

	public class ViewHolder {
		TextView txtDateTime;

		ImageView imageMp;

		TextView txtMpName;
		TextView txtMpConstituency;
		TextView txtDuration;
		TextView txtPoliticalParty;
		ImageView btnViewDetail;

	}

}
