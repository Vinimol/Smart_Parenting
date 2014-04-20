package com.Parent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayOutboxMessage extends Activity{
	TextView idTv,phoneTv,messageTv,dateTv,timeTv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayoutboxmessage);
		
		idTv= (TextView) findViewById(R.id.outboxidTV);
		phoneTv= (TextView) findViewById(R.id.outboxphoneTV);
		messageTv= (TextView) findViewById(R.id.outboxmessageTV);
		dateTv= (TextView) findViewById(R.id.outboxdateTV);
		timeTv= (TextView) findViewById(R.id.outboxtimeTV);
		
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



