package me.kaede.brighter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GamingFragment extends Fragment {

	LayoutInflater inflater;
	private GridController controller;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		View rootView = inflater.inflate(R.layout.fragment_gaming, container, false);
		initView(rootView);
		return rootView;
	}
	
	private void initView(View rootView){
		GridView grid = (GridView) rootView.findViewById(R.id.grid_gaming);
		GamingGridAdapter adapter = new GamingGridAdapter(getActivity());
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(onItemClickListener);
		controller = new GridController(grid,adapter);
		adapter.setGridController(controller);
		controller.reStart();
	}
	
	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			//controller.nextLevel();
		}
	};
	
}