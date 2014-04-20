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

public class WebHistoryNameAdapter extends BaseAdapter {

	String mywebid, myurl, mywebdate, mywebtime;
	Context adapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;

	public WebHistoryNameAdapter(Context adapterContext, JSONArray recvdja) {
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
				R.layout.webhistory_custom_cell, null);
		TextView webid = (TextView) convertView.findViewById(R.id.webidTV);
		TextView url = (TextView) convertView.findViewById(R.id.weburlTV);
		TextView webtime = (TextView) convertView.findViewById(R.id.webtimeTV);
		TextView webdate = (TextView) convertView.findViewById(R.id.webdateTV);
		try {
			recvdjo = (JSONObject) recvdja.get(position);
			mywebid = recvdjo.get("webid").toString();
			myurl = recvdjo.get("weburl").toString();
			mywebdate = recvdjo.get("webdate").toString();
			mywebtime = recvdjo.get("webtime").toString();
			Log.i("webid", "" + mywebid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webid.setText(mywebid);
		url.setText(myurl);
		webdate.setText(mywebdate);
		webtime.setText(mywebtime);
		return convertView;
	}
}
