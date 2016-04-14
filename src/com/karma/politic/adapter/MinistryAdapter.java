package com.karma.politic.adapter;

import java.util.List;

import com.karma.politic.MinistryItem;
import com.karma.politic.MpItem;
import com.karma.politic.R;
import com.karma.politic.adapter.MpAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MinistryAdapter extends BaseAdapter {

	List<MinistryItem> ministryItems;
	Context context;

	public MinistryAdapter(Context context, List<MinistryItem> ministryItems) {

		this.ministryItems = ministryItems;
		this.context = context;
		LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ministryItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ministryItems.get(position);
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

			convertView = inflater.inflate(R.layout.list_ministry, null);
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

		MinistryItem ministryItem = ministryItems.get(position);
		viewHolder.txtDateTime.setText(ministryItem.getDateTime());
		viewHolder.imageMp.setImageDrawable(ministryItem.getImage());
		viewHolder.txtMpName.setText(ministryItem.getName());
		viewHolder.txtMpConstituency.setText(ministryItem.getConstituency());
		viewHolder.txtDuration.setText(ministryItem.getDuration());
		viewHolder.txtPoliticalParty.setText(ministryItem.getParty());
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
