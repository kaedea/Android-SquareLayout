package me.kaede.brighter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_main);
		getSupportFragmentManager().beginTransaction().add(R.id.container, new GamingFragment()).commitAllowingStateLoss();
	}

	
}
