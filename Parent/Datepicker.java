package com.Parent;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Datepicker extends Activity {
	private TextView mDateDisplay;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int myhour,myminute;
    static final int DATE_DIALOG_ID = 1;
    static final int TIME_DIALOG_ID = 2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datepicker);
		 mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
	        Button pickDate = (Button) findViewById(R.id.pickDate);
	        pickDate.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                showDialog(DATE_DIALOG_ID);
	            }
	        });
	        final Calendar c = Calendar.getInstance();
	        mYear = c.get(Calendar.YEAR);
	        mMonth = c.get(Calendar.MONTH);
	        mDay = c.get(Calendar.DAY_OF_MONTH);
	        updateDisplay();
	        myhour=c.get(Calendar.HOUR_OF_DAY);
	        myminute=c.get(Calendar.MINUTE);
	        updateTimeDisplay();
}
	public void timeclick(View v)
    {
    	showDialog(TIME_DIALOG_ID);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
 
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this,
                mDateSetListener,
                mYear, mMonth, mDay);
        case TIME_DIALOG_ID:
            return new TimePickerDialog(this,
                mTimeSetListener,
                myhour, myminute, false);
        }
        return null;
    }
  /*  protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id) {
 
        case DATE_DIALOG_ID:
            ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
            break;
        }
    } */  
    private void updateDisplay() {
        mDateDisplay.setText(
            new StringBuilder()
            // Month is 0 based so add 1
            .append(mMonth + 1).append("-")
            .append(mDay).append("-")
            .append(mYear).append(" "));
    }
    private void updateTimeDisplay() {
        mDateDisplay.setText(
            new StringBuilder()
            
            .append(myhour).append(":")
            .append(myminute));
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener() {
 
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDisplay();
        }
    };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
		
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			myhour=hourOfDay;
			myminute=minute;
			updateTimeDisplay();
		}
};
}