package me.kaede.brighter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GamingGridAdapter extends BaseAdapter {
	LayoutInflater inflater;
	GridController controller;
	int line = 1, column = 1;

	GamingGridAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	public void setGridController(GridController controller) {
		this.controller = controller;
	}

	@Override
	public int getCount() {
		return line * column;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_grid_gaming, parent, false);
		}
		convertView.setTag(position);
		ImageView iv = (ImageView) convertView.findViewById(R.id.iv_grid_cube);
		if(controller.checkPosition(position)){
			iv.setBackgroundColor(controller.getTargetColor());
		}else
		{
			iv.setBackgroundColor(controller.getNormalColor());
		}
		
		iv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				controller.checkLevel(position);
				return true;
			}
		});
		/*convertView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					int pos = (int) v.getTag();
					Log.e("GamingGridAdapter", "pos=" + pos);
					controller.checkLevel(pos);
				}
				return true;
			}
		});*/
		convertView.requestLayout();
		return convertView;
	}

}