package com.Parent;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class IncomingCallLogActivity extends Activity implements IP {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incoming_call_log);
		ListView myListView = (ListView) findViewById(R.id.myIncomingcall);
		WebServ w1 = new WebServ();
		try {
			int id=ParentActivity.loginid;
			
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);

			namevaluepair.add(new BasicNameValuePair("loginid",""+id));

			JSONArray ja = w1.doPost(namevaluepair, "http://" +ip+ "/SmartParentingServer1/webservice-android/IncomingCall.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			String myphone = jo.get("phonenumber").toString();
			Toast.makeText(this,"hai"+myphone , Toast.LENGTH_LONG).show();
			
			IncomingCallAdapter adapter = new IncomingCallAdapter(IncomingCallLogActivity.this,ja);
			myListView.setAdapter(adapter);

			// String myphone = jo.get("phone").toString();
			// String mypassword = jo.get("password").toString();
			// Toast.makeText(this, "hai"+msg+myname, Toast.LENGTH_LONG).show();
		} catch (Exception e) {

		}


}

}
