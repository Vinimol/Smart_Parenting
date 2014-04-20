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

public class NameAdapter extends BaseAdapter {

	String phoneno, inboxid;
	Context adapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;

	public NameAdapter(Context adapterContext, JSONArray recvdja) {
		super();
		this.adapterContext = adapterContext;
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

		convertView = LayoutInflater.from(adapterContext).inflate(
				R.layout.custom_cell, null);
		TextView phone = (TextView) convertView
				.findViewById(R.id.inboxphonenoTV);
		TextView id = (TextView) convertView.findViewById(R.id.inboxidTV);
		try {
			recvdjo = (JSONObject) recvdja.get(position);
			phoneno = recvdjo.get("phonenumber").toString();
			inboxid = recvdjo.get("inboxid").toString();
			Log.i("phoneno", "" + phoneno);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phone.setText(phoneno);
		id.setText("message id: "+inboxid);
		return convertView;
	}

}
