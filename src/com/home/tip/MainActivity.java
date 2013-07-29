package com.home.tip;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculate(View view){
		Intent calculationIntent = new Intent(this, CalculationActivity.class);
		EditText totalAmountView = (EditText) this.findViewById(R.id.total_amount_id);
		String  totalAmountString = totalAmountView.getText().toString();
		
		calculationIntent.putExtra(TipConstant.TOTAL_AMOUNT, totalAmountString);
		this.startActivity(calculationIntent);
	}
}
