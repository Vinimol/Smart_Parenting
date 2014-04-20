package com.Parent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class IncomingCallAdapter extends BaseAdapter {
	Context incomingcallAdapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;
	String phoneno,incomingid,incomingdate, incomingtime, incomingduration;	


	public IncomingCallAdapter(Context incomingcallAdapterContext,
			JSONArray recvdja) {
		super();
		this.incomingcallAdapterContext = incomingcallAdapterContext;
		this.recvdja = recvdja;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return recvdja.length();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(incomingcallAdapterContext).inflate(R.layout.incomingcall_customcell,null);
		Log.i("2iinboxid","222");
		TextView phone = (TextView) convertView.findViewById(R.id.incomingphonenoTV);
		TextView id = (TextView) convertView.findViewById(R.id.incomingidTV);
		
		TextView date = (TextView) convertView.findViewById(R.id.incomingdateTV);
		TextView time = (TextView) convertView.findViewById(R.id.incomingtimeTV);
		TextView duration = (TextView) convertView.findViewById(R.id.incomingcalldurationTV);
		
		try {
			recvdjo=(JSONObject) recvdja.get(position);
			 
			phoneno = recvdjo.get("phonenumber").toString();
			 incomingid = recvdjo.get("incomingid").toString();
				 
			 incomingdate = recvdjo.get("date").toString();
			 incomingtime = recvdjo.get("time").toString();
			 incomingduration = recvdjo.get("duration").toString();
			
				
			Log.i("phoneno",""+phoneno);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		phone.setText(phoneno);
		//id.setText(incomingid);
		date.setText(incomingdate);
		time.setText(incomingtime);
		duration.setText(incomingduration);
		return convertView;
	}

}
