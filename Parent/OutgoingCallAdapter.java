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

public class OutgoingCallAdapter extends BaseAdapter {
	Context outgoingcallAdapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;
	String phoneno,outgoingid,outgoingdate, outgoingtime, outgoingduration;	;	

	public OutgoingCallAdapter(Context outgoingcallAdapterContext,
			JSONArray recvdja) {
		super();
		this.outgoingcallAdapterContext = outgoingcallAdapterContext;
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
		convertView = LayoutInflater.from(outgoingcallAdapterContext).inflate(R.layout.outgoingcall_customcell,null);
		Log.i("2iinboxid","222");
		TextView phone = (TextView) convertView.findViewById(R.id.outgoingphonenoTV);
		TextView id = (TextView) convertView.findViewById(R.id.outgoingidTV);
		TextView date = (TextView) convertView.findViewById(R.id.outgoingdateTV);
		TextView time = (TextView) convertView.findViewById(R.id.outgoingtimeTV);
		TextView duration = (TextView) convertView.findViewById(R.id.outgoingdurationTV);
		try {
			recvdjo=(JSONObject) recvdja.get(position);
			 phoneno = recvdjo.get("phonenumber").toString();
			 outgoingid = recvdjo.get("outgoingid").toString();
			 outgoingdate = recvdjo.get("date").toString();
			 outgoingtime = recvdjo.get("time").toString();
			 outgoingduration = recvdjo.get("duration").toString();
			
			
			Log.i("phoneno",""+phoneno);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phone.setText(phoneno);
		//id.setText(outgoingid);
		date.setText(outgoingdate);
		time.setText(outgoingtime);
		duration.setText(outgoingduration);
		return convertView;
	}

}
