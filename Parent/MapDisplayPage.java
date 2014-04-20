package com.Parent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapDisplayPage extends MapActivity implements IP {
	// TextView dateDisplayTV,timeDisplayTV;
	private TextView mDateDisplay, mTimeDisplay;
	private int mYear;
	private int mMonth;
	private int mDay;
	private int myhour, myminute;
	static final int DATE_DIALOG_ID = 1;
	static final int TIME_DIALOG_ID = 2;

	JSONArray ja;
	int i = 0;
	HelloItemizedOverlay itemizedoverlay;
	OverlayItem overlayitem;
	List<Overlay> mapOverlays;
	
	MapView mapView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
		mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
		Button pickDate = (Button) findViewById(R.id.pickDate);
		mapView = (MapView) findViewById(R.id.mapview);
		
		int la = (int) (10.194461800000000000 * 1E6);
		int lo = (int) (76.407133599999950000* 1E6);
		GeoPoint point1 = new GeoPoint(la,lo);
	
		mapView.getController().setCenter(point1);
		   mapView.invalidate();
		

		pickDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});
		Button pickTime = (Button) findViewById(R.id.pickTime);
		pickTime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(TIME_DIALOG_ID);
			}
		});
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplay();

		myhour = c.get(Calendar.HOUR_OF_DAY);
		myminute = c.get(Calendar.MINUTE);
		updateTimeDisplay();

		Toast.makeText(this, "hiiiiiii", Toast.LENGTH_LONG).show();

		
		mapView.getController().setZoom(16);
		mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.justpin);
		itemizedoverlay = new HelloItemizedOverlay(drawable, this);
	}

	public void timeclick(View v) {
		showDialog(TIME_DIALOG_ID);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, myhour,
					myminute, true);
		}
		return null;
	}

	private void updateDisplay() {
		mDateDisplay.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mYear).append("-").append(mMonth + 1).append("-")
				.append(mDay).append(" "));
	}

	private void updateTimeDisplay() {
		mTimeDisplay.setText(new StringBuilder()

		.append(myhour).append(":").append(myminute));
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};
	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			myhour = hourOfDay;
			myminute = minute;
			updateTimeDisplay();
		}
	};

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

	public void plot(View v, JSONObject jo) {

		String latitude = "";
		String longitude = "";
		String location= "";
		try {

			latitude = jo.getString("latitude");
			Toast.makeText(this, "lat"+latitude, Toast.LENGTH_LONG).show();
			longitude = jo.getString("longitude");
			Toast.makeText(this, "long"+longitude, Toast.LENGTH_LONG).show();
			location= jo.getString("location");
			Log.e("location", "lat = "+latitude + "long = "+ longitude + "location = " +location);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Toast.makeText(this, "latitude" + latitude + "longitude" + longitude,
				//Toast.LENGTH_LONG).show();
		Double lat = Double.parseDouble(latitude);
		int la = (int) (lat * 1E6);
		Double lng = Double.parseDouble(longitude);

		int lo = (int) (lng * 1E6);
Log.e("map location", "lat = " + lat + "   long = "+ lng);
Log.e("map location", "la = " + la + "   lng = "+ lo);
		GeoPoint point = new GeoPoint(la, lo);
		overlayitem = new OverlayItem(point,"iam in",location);
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		mapView.getController().setCenter(point);
		mapView.invalidate();

		
//		mapView.getController().zoomToSpan(itemizedoverlay.getLatSpanE6(),
//				itemizedoverlay.getLonSpanE6());
	}

	public void submitbtnclick(View v) {

		//Toast.makeText(this, "haiiisubmit", Toast.LENGTH_LONG).show();
		WebServ w1 = new WebServ();
		try {
			int id = ParentActivity.loginid;
			String dateoflocation = mDateDisplay.getText().toString();
			String timeonlocation = mTimeDisplay.getText().toString();
			Toast.makeText(this, timeonlocation, Toast.LENGTH_LONG).show();
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(3);

			namevaluepair.add(new BasicNameValuePair("date", dateoflocation));
			namevaluepair.add(new BasicNameValuePair("time", timeonlocation
					+ ":00"));
			namevaluepair.add(new BasicNameValuePair("loginid", "" + id));

			ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/maphistory.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			Log.i("ja", "" + ja);
			plot(v, jo);
		} catch (Exception e) {
			Toast.makeText(this, "errorrrr", Toast.LENGTH_LONG).show();

		}
	}

	public void nextclicked(View v) {
	//	Toast.makeText(this, "next", Toast.LENGTH_SHORT).show();

		try {
			i--;
			if (i > 0 && i < ja.length()) {
				Log.i("next  i", "" + i);
				JSONObject jo;
				try {
					jo = (JSONObject) ja.get(i);
					Log.i("next jo", "" + jo);
					plot(v, jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Toast.makeText(this, "out of bound", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("excepton", "" + e);
			e.printStackTrace();
		}

	}

	public void previousClicked(View v1) {
		i++;
		Log.i("prev1  i", "" + i);
		if (ja.length() >= i && i >= 0) {
			Log.i("prev2  i", "" + i);

			JSONObject jo;
			try {
				jo = (JSONObject) ja.get(i);
				plot(v1, jo);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			Toast.makeText(this, "out of bound", Toast.LENGTH_SHORT).show();
		}
	}

}
