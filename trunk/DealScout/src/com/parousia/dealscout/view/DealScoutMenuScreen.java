package com.parousia.dealscout.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parousia.dealscout.R;

public class DealScoutMenuScreen extends DealScoutScreen {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.menu_screen);
		GridView menuGrid = (GridView) findViewById(R.id.menugrid);
		menuGrid.setAdapter(new CustomAdapter(this));

	}

	public class CustomAdapter extends BaseAdapter {
		private Context mContext;

		public CustomAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return mThumbIds.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout tileLayout;
			ImageView imageView;
			TextView textView;
			if (convertView == null) {// if it's not recycled, initialize some
										// attributes
				tileLayout = new LinearLayout(mContext);
				tileLayout.setLayoutParams(new GridView.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT,
						ViewGroup.LayoutParams.WRAP_CONTENT));
				tileLayout.setPadding(6, 6, 6, 6);
				tileLayout.setOrientation(LinearLayout.VERTICAL);
			} else {
				tileLayout = (LinearLayout) convertView;
				return tileLayout;
			}
			imageView = new ImageView(mContext);
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setPadding(2, 2, 2, 2);
			imageView.setImageResource(mThumbIds[position]);
			textView = new TextView(mContext);
			textView.setText("Restaurant");
			tileLayout.addView(imageView);
			tileLayout.addView(textView);
			return tileLayout;
		}

		// references to our images
		private Integer[] mThumbIds = { R.drawable.restaurant,
				R.drawable.restaurant, R.drawable.restaurant };
	}
}
