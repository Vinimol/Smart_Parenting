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

public class ContactsNameAdapter extends BaseAdapter {
	String name,number1,number2;
	Context adapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;


	public ContactsNameAdapter(Context adapterContext, JSONArray recvdja) {
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
				R.layout.contacts_custom_cell, null);
		TextView contactname = (TextView) convertView
				.findViewById(R.id.contactnameTV);
		TextView no1 = (TextView) convertView.findViewById(R.id.contactno1TV);
		TextView no2 = (TextView) convertView.findViewById(R.id.contactno2TV);
		try {
			recvdjo = (JSONObject) recvdja.get(position);
			name = recvdjo.get("contactname").toString();
			number1 = recvdjo.get("contact1").toString();
			number2= recvdjo.get("contact2").toString();

			Log.i("phoneno", "" + name);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contactname .setText(name);
		no1.setText(number1);
		no2.setText(number2);
		return convertView;
	}

	}


