package com.Parent;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class ParentHomeActivity extends Activity implements IP{
	SharedPreferences myshared;
	int location1_flag,location2_flag;
	Handler h1=new Handler();
	Location currentLoc = new Location(LocationManager.GPS_PROVIDER);
	Location restloc1 = new Location(LocationManager.GPS_PROVIDER);
	Location restloc2 = new Location(LocationManager.GPS_PROVIDER);
@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parenthome);
        h1.postDelayed(r1,1000);
           }
public void messageButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,MessageActivity.class);
	startActivity(myIntent);
}
public void webhistoryButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,WebHistoryActivity.class);
	startActivity(myIntent);
}


public void calllogButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,CallLogActivity.class);
	startActivity(myIntent);
}
public void gpslocationButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,MapDisplayPage.class);
	startActivity(myIntent);
}
public void markrestrictedareaButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,MarkRestrictedAreaActivity.class);
	startActivity(myIntent);
}

public void contactsButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,ContactsDisplayActivity.class);
	startActivity(myIntent);
}
public void FileButtonClicked(View v)
{
	Intent myIntent=new Intent(ParentHomeActivity.this,FileLogActivity.class);
	startActivity(myIntent);
}
public void SimStatus()
{
	WebServ w1 = new WebServ();
	try {

		int id=ParentActivity.loginid;
		List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);

		namevaluepair.add(new BasicNameValuePair("loginid",""+id));

		JSONArray ja = w1.doPost(namevaluepair, "http://" +ip+ "/SmartParentingServer1/webservice-android/Simchangedisplay.jsp");
		JSONObject jo = (JSONObject) ja.get(0);
		
	//WebHistoryNameAdapter adapter = new WebHistoryNameAdapter(WebHistoryActivity.this,ja);
	//	myListView.setAdapter(adapter);
		 String status = jo.get("status").toString();
		// String mypassword = jo.get("password").toString();
		// Toast.makeText(this, ""+status, Toast.LENGTH_LONG).show();
		 if(status.equals("1"))
		 {
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

				// status bar notifications
				Notification notifyDetails = new Notification(R.drawable.ic_launcher,
						"New Alert, Click Me!", System.currentTimeMillis());

				// on notification click
				CharSequence contentTitle = "Notification Details.........";

				CharSequence contentText = "Child has inserted new sim";
				Intent notificationIntent = new Intent(this,
						ParentHomeActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
						notificationIntent, 0);

				notifyDetails.setLatestEventInfo(this, contentTitle, contentText,
						contentIntent);
				mNotificationManager.notify(1, notifyDetails);
		 }
		 else if(status.equals("0"))
		 {
			 NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

				// status bar notifications
				Notification notifyDetails = new Notification(R.drawable.ic_launcher,
						"New Alert, Click Me!", System.currentTimeMillis());

				// on notification click
				CharSequence contentTitle = "Notification Details.........";

				CharSequence contentText = "child has restarted the phone";
				Intent notificationIntent = new Intent(this,
						ParentHomeActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
						notificationIntent, 0);

				notifyDetails.setLatestEventInfo(this, contentTitle, contentText,
						contentIntent);
				mNotificationManager.notify(1, notifyDetails);
			 
		 }
			 
	} catch (Exception e) {
		
		Toast.makeText(this,"  "+e,10000).show();
	}
}
public void Restrictedarea()
{
	WebServ w1 = new WebServ();
	try {

		int id=ParentActivity.loginid;
		List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);

		namevaluepair.add(new BasicNameValuePair("loginid",""+id));

		JSONArray ja = w1.doPost(namevaluepair, "http://" +ip+ "/SmartParentingServer1/webservice-android/mapmark.jsp");
		JSONObject jo = (JSONObject) ja.get(0);
		
	//WebHistoryNameAdapter adapter = new WebHistoryNameAdapter(WebHistoryActivity.this,ja);
	//	myListView.setAdapter(adapter);
		 String latitude = jo.getString("latitude");
		 String longitude = jo.getString("longitude");
		 String location = jo.get("location").toString();
		 
		 double lat=Double.parseDouble(latitude);
		// Toast.makeText(this,""+latitude+"  "+latitude,10000).show();
		 double lng=Double.parseDouble(longitude);
		
		 myshared=PreferenceManager.getDefaultSharedPreferences(this);
		 String restlat1=myshared.getString("lat1", "");
		 String restlog1=myshared.getString("log1", "");
		 String restlat2=myshared.getString("lat2", "");
		 String restlog2=myshared.getString("log2", "");
		 double rest_lat1=Double.parseDouble(restlat1);
		 double rest_lng1=Double.parseDouble(restlog1);
		 double rest_lat2=Double.parseDouble(restlat2);
		 double rest_lng2=Double.parseDouble(restlog2);
		// Toast.makeText(this,""+restlat1+"  "+restlog1,10000).show();
		    currentLoc.setLatitude(lat);
			currentLoc.setLongitude(lng);
			restloc1.setLatitude(rest_lat1);
			restloc1.setLongitude(rest_lng1);
			restloc2.setLatitude( rest_lat2);
			restloc2.setLongitude( rest_lng2);
			if(currentLoc.distanceTo(restloc1)>5 && location1_flag==0)
			{

				NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

					// status bar notifications
					Notification notifyDetails = new Notification(R.drawable.ic_launcher,
							"New Alert, Click Me!", System.currentTimeMillis());

					// on notification click
					CharSequence contentTitle = "Notification Details.........";

					CharSequence contentText = "Child has reached near Restricted location"+"\n"+location;
					Intent notificationIntent = new Intent(this,
							ParentHomeActivity.class);
					PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
							notificationIntent, 0);

					notifyDetails.setLatestEventInfo(this, contentTitle, contentText,
							contentIntent);
					mNotificationManager.notify(1, notifyDetails);
					location2_flag=0;
					location1_flag=1;
			 
			}
			 else if(currentLoc.distanceTo(restloc2)>5 && location2_flag==0)
			 {
				 NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				 location1_flag=0;
				 location2_flag=1;
					// status bar notifications
					Notification notifyDetails = new Notification(R.drawable.ic_launcher,
							"New Alert, Click Me!", System.currentTimeMillis());

					// on notification click
					CharSequence contentTitle = "Notification Details.........";

					CharSequence contentText = "Child has Entered Restricted location"+""+location;
					Intent notificationIntent = new Intent(this,
							ParentHomeActivity.class);
					PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
							notificationIntent, 0);

					notifyDetails.setLatestEventInfo(this, contentTitle, contentText,
							contentIntent);
					mNotificationManager.notify(1, notifyDetails);
				 
			 }
	}
	catch (Exception e) {
		 Toast.makeText(this,"  "+e,10000).show();
	}
		 
		 
}
Runnable r1=new Runnable() {
	
	public void run() {
		SimStatus();
		Restrictedarea();
		h1.postDelayed(r1,30000);
		
	}
		
};
}
