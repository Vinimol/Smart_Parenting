package com.Parent;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class OutboxActivity extends Activity implements IP {
	JSONArray ja;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outbox);
		ListView myListView = (ListView) findViewById(R.id.myOutbox);
		WebServ w1 = new WebServ();
		try {
			int id=ParentActivity.loginid;
			Log.i("my id","hi....."+id);

			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);
			
			namevaluepair.add(new BasicNameValuePair("loginid", ""+id));
			ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/Outbox.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			NameAdapter adapter = new NameAdapter(OutboxActivity.this, ja);
			myListView.setAdapter(adapter);
			
			myListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					try {
						JSONObject selectjo = (JSONObject) ja.get(arg2);
						String outboxid = selectjo.getString("outboxid");
						String phone = selectjo.getString("phonenumber");
						String message = selectjo.getString("message");
						String dateofmessage = selectjo.getString("date");
						String timeofmessage = selectjo.getString("time");
						Log.i("outbox id", outboxid);
						Intent displaymessage = new Intent(OutboxActivity.this,
								DisplayOutboxMessage.class);
						displaymessage.putExtra("id", outboxid);
						displaymessage.putExtra("phone", phone);
						displaymessage.putExtra("message", message);
						displaymessage.putExtra("date", dateofmessage);
						displaymessage.putExtra("time", timeofmessage);
						startActivity(displaymessage);
						// Toast.makeText(this,"hai"+a,
						// Toast.LENGTH_LONG).show();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});

		} catch (Exception e) {
		}
	}
}
