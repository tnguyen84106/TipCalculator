package com.home.tip;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class CalculationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		boolean invalid = false;
		Intent intent = this.getIntent();
		String totalAmountString = intent.getStringExtra(TipConstant.TOTAL_AMOUNT);
		for(int i = 0; i < totalAmountString.length(); i++){
			if(!Character.isDigit(totalAmountString.charAt(i))){
				invalid = true;
				break;
			}
		}
		
		TextView textView = new TextView(this);
		if(invalid){
			textView.setError("Invalid total amount. It should be numbers not characters.");
			textView.setText("Invalid total amount. It should be numbers not characters.");
		}else{
			double tipAmount = Double.valueOf((String)totalAmountString) * 0.15;
			textView.setText("Tip amount: " +  String.valueOf(tipAmount));
		}
		
		setContentView(textView);
		//setContentView(R.layout.activity_calculation);
		// Show the Up button in the action bar.
		//setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculation, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
