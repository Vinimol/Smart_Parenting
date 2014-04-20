package com.Parent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MessageActivity extends Activity{
@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
           
}
public void inboxButtonClicked(View v)
{
	Intent myInbox=new Intent(MessageActivity.this,InboxActivity.class);
	startActivity(myInbox);
}

public void outboxButtonClicked(View v)
{
	Intent myOutbox=new Intent(MessageActivity.this,OutboxActivity.class);
	startActivity(myOutbox);
}


}
