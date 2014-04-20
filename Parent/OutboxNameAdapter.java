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

public class OutboxNameAdapter extends BaseAdapter {
	Context outboxAdapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;
	String phoneno,outboxid;	
	public OutboxNameAdapter(Context outboxAdapterContext, JSONArray recvdja) {
		super();
		this.outboxAdapterContext = outboxAdapterContext;
		this.recvdja = recvdja;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return recvdja.length();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(outboxAdapterContext).inflate(R.layout.outbox_custom_cell,null);
		Log.i("2iinboxid","222");
		TextView phone = (TextView) convertView.findViewById(R.id.outboxphonenoTV);
		TextView id = (TextView) convertView.findViewById(R.id.outboxidTV);
		try {
			recvdjo=(JSONObject) recvdja.get(position);
			 phoneno = recvdjo.get("phonenumber").toString();
			 outboxid = recvdjo.get("outboxid").toString();
			Log.i("phoneno",""+phoneno);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phone.setText(phoneno);
		id.setText(outboxid);
		return convertView;
	}
	
	}
	

