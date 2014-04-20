package com.Parent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessage extends Activity {
	TextView idTv,phoneTv,messageTv,dateTv,timeTv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displaymessage);
		
		idTv= (TextView) findViewById(R.id.idTV);
		phoneTv= (TextView) findViewById(R.id.phoneTV);
		messageTv= (TextView) findViewById(R.id.messageTV);
		dateTv= (TextView) findViewById(R.id.dateTV);
		timeTv= (TextView) findViewById(R.id.timeTV);
		
	String	inboxid = getIntent().getStringExtra("id");
	String	phone = getIntent().getStringExtra("phone");
	String	message = getIntent().getStringExtra("message");
	String	date= getIntent().getStringExtra("date");
	String	time = getIntent().getStringExtra("time");
	
			idTv.setText(inboxid);
			phoneTv.setText(phone);
			messageTv.setText(message);
			dateTv.setText(date);
			timeTv.setText(time);
			}

}
