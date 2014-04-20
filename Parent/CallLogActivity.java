package com.Parent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CallLogActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calllog);
	}

	public void outgoingCallButtonClicked(View v) {
		Intent myIntent = new Intent(CallLogActivity.this,
				OutgoingCallLogActivity.class);
		startActivity(myIntent);
	}

	public void incomingCallButtonClicked(View v) {
		Intent myIntent = new Intent(CallLogActivity.this,
				IncomingCallLogActivity.class);
		startActivity(myIntent);
	}

}
