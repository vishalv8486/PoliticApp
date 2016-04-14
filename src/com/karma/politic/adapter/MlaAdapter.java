package com.karma.politic.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karma.politic.MlaItem;
import com.karma.politic.R;
import com.karma.politic.RoundImage;

public class MlaAdapter extends BaseAdapter {

	// LayoutInflater inflater;
	List<MlaItem> mlaItems;
	Context context;

	public MlaAdapter(Context context, List<MlaItem> mlaItems) {
		this.context = context;
		this.mlaItems = mlaItems;
		LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlaItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mlaItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		RoundImage roundedImage;

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_mla, null);

			viewHolder = new ViewHolder();

			viewHolder.imageMla = (ImageView) convertView.findViewById(R.id.mlaImage);

			/*
			 * Bitmap bm = BitmapFactory.decodeResource(Resources res,);
			 * roundedImage = new RoundImage(bm);
			 * viewHolder.imageMla.setImageDrawable(roundedImage);
			 */

			viewHolder.txtDateTime = (TextView) convertView.findViewById(R.id.textDateTime);
			viewHolder.txtMlaName = (TextView) convertView.findViewById(R.id.textMlaName);
			viewHolder.txtMlaConstituency = (TextView) convertView.findViewById(R.id.textConstituency);
			viewHolder.txtPoliticalParty = (TextView) convertView.findViewById(R.id.textParty);
			viewHolder.txtDuration = (TextView) convertView.findViewById(R.id.textDuration);
			viewHolder.btnViewDetail = (ImageView) convertView.findViewById(R.id.btnViewDetail);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		MlaItem mlaItem = mlaItems.get(position);
		viewHolder.imageMla.setImageDrawable(mlaItem.getImageMlaIcon());
		viewHolder.txtDateTime.setText(mlaItem.getDateTime());
		viewHolder.txtMlaName.setText(mlaItem.getMlaName());
		viewHolder.txtMlaConstituency.setText(mlaItem.getMlaConstituency());
		viewHolder.txtDuration.setText(mlaItem.getMlaDuration());
		viewHolder.txtPoliticalParty.setText(mlaItem.getMlaParty());

		viewHolder.btnViewDetail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(context, "YOu clicked on View Details", Toast.LENGTH_SHORT).show();

			}
		});

		return convertView;
	}

	public class ViewHolder {
		TextView txtDateTime;

		ImageView imageMla;

		TextView txtMlaName;
		TextView txtMlaConstituency;
		TextView txtDuration;
		TextView txtPoliticalParty;
		ImageView btnViewDetail;

	}

}
