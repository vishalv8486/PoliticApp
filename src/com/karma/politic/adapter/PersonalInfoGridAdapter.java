package com.karma.politic.adapter;

import java.util.List;

import com.karma.politic.PersonalInfoGridItem;
import com.karma.politic.R;
import com.karma.politic.adapter.MlaAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalInfoGridAdapter extends BaseAdapter {

	Context context;
	List<PersonalInfoGridItem> personalInfoGridItems;

	public PersonalInfoGridAdapter(Context context,
			List<PersonalInfoGridItem> personalInfoGridItems) {

		this.context = context;
		this.personalInfoGridItems = personalInfoGridItems;
		LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return personalInfoGridItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return personalInfoGridItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {

			convertView = inflater.inflate(R.layout.grid_personal, null);
			viewHolder = new ViewHolder();
			viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
			viewHolder.text = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(viewHolder);

		} else {

			viewHolder = (ViewHolder) convertView.getTag();
		}

		PersonalInfoGridItem personalInfoGridItem = personalInfoGridItems
				.get(position);
		viewHolder.image.setImageDrawable(personalInfoGridItem.getImage());
		viewHolder.text.setText(personalInfoGridItem.getText());

		return convertView;
	}

	public class ViewHolder {
		TextView text;
		ImageView image;

	}

}
