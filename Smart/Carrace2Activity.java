package smart.com;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.TranslateAnimation;

public class Carrace2Activity extends Activity implements SensorEventListener
{
	public static int x = 0;
	public static int y = 0;
	public static int status = 0;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	static Vibrator v;
	BallView ballView;
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		int w = getWindowManager().getDefaultDisplay().getWidth() - 25;
		int h = getWindowManager().getDefaultDisplay().getHeight() - 25;
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(this, mAccelerometer,
				SensorManager.SENSOR_DELAY_NORMAL);
	 ballView = new BallView(this, w, h);
		setContentView(ballView);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
	}
	
	@Override
	public void onPause(){
	    super.onPause();
	    ballView.thread.startrun(false);
	   // ballView.thread.stop();
	    this.finish();
	}
	public void onAccuracyChanged(Sensor arg0, int arg1)
	{
		// TODO Auto-generated method stub

	}

	public void onSensorChanged(SensorEvent arg0)
	{
		// TODO Auto-generated method stub

		x = (int) arg0.values[0];
	}

}

class GameSound
{

	private SoundPool mSoundPool;
	private HashMap mSoundPoolMap;
	private AudioManager mAudioManager;
	private Context mContext;

	public void initSounds(Context theContext)
	{
		mContext = theContext;
		mSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		mSoundPoolMap = new HashMap();
		mAudioManager = (AudioManager) mContext
				.getSystemService(Context.AUDIO_SERVICE);
	}

	public void addSound(int index, int SoundID)
	{
		mSoundPoolMap.put(index, mSoundPool.load(mContext, SoundID, 1));
	}

	public void playSound(int index)
	{
		float streamVolume = mAudioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		streamVolume = streamVolume
				/ mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		mSoundPool.play((Integer) mSoundPoolMap.get(index), streamVolume,
				streamVolume, 1, 0, 1f);
	}

	public void playLoopedSound(int index)
	{
		float streamVolume = mAudioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		streamVolume = streamVolume
				/ mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		mSoundPool.play((Integer) mSoundPoolMap.get(index), streamVolume,
				streamVolume, 1, -1, 1f);
	}

}

class BallView extends SurfaceView implements SurfaceHolder.Callback
{

	static int speed = 10;
	private Bitmap bitmap, bitmap2, bitmap1, car1, car2,car3,car4;
	MyThread thread;
	private int x = 20, y = 20;
	int width, height;
	int carposx = 100, carposy = 100;
	int carpos1x = 60, carpos1y = -400;
	int carpos2x = 90, carpos2y = 500;
	int carpos3x = 60, carpos3y = 300;
	int carpos4x = 90, carpos4y = -300;
	int roadposx = 0, roadposy = 0;
	int roadposx1 = 0, roadposy1 = -200;

	public void checkAccident()
	{

		if (carposx <= carpos1x & carposx+25 >= carpos1x
				& carposy <= carpos1y & carposy+40 >= carpos1y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos1x <= carposx & carpos1x+25 >= carposx
				& carpos1y <= carposy & carpos1y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos1x <= carposx+25 & carpos1x+25 >= carposx+25
				& carpos1y <= carposy & carpos1y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos1x <= carposx+25 & carpos1x+25 >= carposx+25
				& carpos1y <= carposy & carpos1y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		
		
		if (carposx <= carpos2x & carposx+25 >= carpos2x
				& carposy <= carpos2y & carposy+35 >= carpos2y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos2x <= carposx & carpos2x+25 >= carposx
				& carpos2y <= carposy & carpos2y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carposx <= carpos2x+25 & carposx+25 >= carpos2x+25
				& carposy <= carpos2y & carposy+35 >= carpos2y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos2x <= carposx+25 & carpos2x+25 >= carposx+25
				& carpos2y <= carposy & carpos2y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		
		
		

		if (carposx <= carpos3x & carposx+25 >= carpos3x
				& carposy <= carpos3y & carposy+35 >= carpos3y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos3x <= carposx & carpos3x+25 >= carposx
				& carpos3y <= carposy & carpos3y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carposx <= carpos3x+25 & carposx+25 >= carpos3x+25
				& carposy <= carpos3y & carposy+35 >= carpos3y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos3x <= carposx+25 & carpos3x+25 >= carposx+25
				& carpos3y <= carposy & carpos3y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}
		
		
		
		
		

		if (carposx <= carpos4x & carposx+25 >= carpos4x
				& carposy <= carpos4y & carposy+35 >= carpos4y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos4x <= carposx & carpos4x+25 >= carposx
				& carpos4y <= carposy & carpos4y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}

		if (carposx <= carpos4x+25 & carposx+25 >= carpos4x+25
				& carposy <= carpos4y & carposy+35 >= carpos4y)
		{

			Carrace2Activity.v.vibrate(300);

		}
		if (carpos4x <= carposx+25 & carpos4x+25 >= carposx+25
				& carpos4y <= carposy & carpos4y+35 >= carposy)
		{

			Carrace2Activity.v.vibrate(300);

		}

		
	}

	public BallView(Context context, int w, int h)
	{
		super(context);

		width = w;
		height = h;
		thread = new MyThread(getHolder(), this);
		getHolder().addCallback(this);
		setFocusable(true);

	}

	public void car1()
	{

		if (speed <= 10)
		{
			carpos1y = carpos1y - 15;

		} else if (carpos1y >= 2500)
		{
			carpos1y = -200;
		}
		else if (carpos1y <= -500)
		{
			carpos1y =400;
		} else
		{

			carpos1y = carpos1y - 15 + speed;
		}
	}

	public void car2()
	{

		if (speed <= 10)
		{
			carpos2y = carpos2y - 25;

		} else if (carpos2y >= 3000)
		{
			carpos2y = -200;
		}
		else if (carpos2y <= -500)
		{
			carpos2y =400;
		}else
		{

			carpos2y = carpos2y - 25 + speed;
		}
	}
	
	public void car3()
	{

		if (speed <= 10)
		{
			carpos3y = carpos3y - 15;

		} else if (carpos3y >= 3000)
		{
			carpos3y = -200;
		} 
		else if (carpos3y <= -500)
		{
			carpos3y =400;
		}else
		{

			carpos3y = carpos3y - 15 + speed;
		}
	}
	
	public void car4()
	{

		if (speed <= 10)
		{
			carpos4y = carpos4y - 25;

		} else if (carpos4y >= 3000)
		{
			carpos4y = -200;
		} 
		else if (carpos4y <= -500)
		{
			carpos4y =400;
		}else
		{

			carpos4y = carpos4y - 25 + speed;
		}
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		car1();
		car2();
		car3();
		car4();

		if (roadposy >= 200)
		{

			roadposy = -200;

		}
		if (roadposy1 >= 200)
		{

			roadposy1 = -200;

		}
		roadposy = roadposy + speed;
		roadposy1 = roadposy1 + speed;
		carposx = 120 - (7 * Carrace2Activity.x);
		car1 = BitmapFactory.decodeResource(getResources(), R.drawable.car1);

		car2 = BitmapFactory.decodeResource(getResources(), R.drawable.car2);
		car3 = BitmapFactory.decodeResource(getResources(), R.drawable.car3);

		car4 = BitmapFactory.decodeResource(getResources(), R.drawable.car4);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bk);
		bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.bk);
		bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.car);
		canvas.drawColor(Color.BLUE);// To make background
		canvas.drawBitmap(bitmap, roadposx, roadposy, null);
		canvas.drawBitmap(bitmap, roadposx1, roadposy1, null);

		canvas.drawBitmap(car1, carpos1x, carpos1y, null);
		canvas.drawBitmap(car2, carpos2x, carpos2y, null);
		canvas.drawBitmap(car3, carpos3x, carpos3y, null);
		canvas.drawBitmap(car4, carpos4x, carpos4y, null);
		
		canvas.drawBitmap(bitmap2, carposx, carposy, null);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{

		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN)
		{

			Carrace2Activity.status = 1;
			GameSound mSoundManager = new GameSound();
			mSoundManager.initSounds(getContext());
			mSoundManager.addSound(1, R.raw.cartcar);
			mSoundManager.playSound(1);

		}

		else if (action == MotionEvent.ACTION_UP)
		{
			Carrace2Activity.status = 0;
		}
		x = (int) event.getX();
		y = (int) event.getY();

		if (x < 25)
			x = 25;
		if (x > width)
			x = width;
		if (y < 25)
			y = 25;
		if (y > 405)
			y = 405;
		return true;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height)
	{
		// TODO Auto-generated method stub
		
		


	}

	public void surfaceCreated(SurfaceHolder holder)
	{

		thread.startrun(true);
		thread.start();

	}

	public void surfaceDestroyed(SurfaceHolder holder)
	{

		thread.startrun(false);
		thread.stop();
		

	}
}

class MyThread extends Thread
{

	private SurfaceHolder msurfaceHolder;
	private BallView mballView;
	private boolean mrun = false;

	public MyThread(SurfaceHolder holder, BallView ballView)
	{

		msurfaceHolder = holder;
		mballView = ballView;
	}

	public void startrun(boolean run)
	{

		mrun = run;
	}

	@Override
	public void run()
	{

		super.run();

		Canvas canvas;
		while (mrun)
		{
			mballView.checkAccident();
			roadMovement();
			//Log.e("speed", "" + BallView.speed);
			canvas = null;
			try
			{
				
				canvas = msurfaceHolder.lockCanvas(null);
				synchronized (msurfaceHolder)
				{
					mballView.onDraw(canvas);
				}
			} finally
			{
				if (canvas != null)
				{
					msurfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}

	public void roadMovement()
	{

		if (BallView.speed > 10 & Carrace2Activity.status == 0)
		{
			BallView.speed = BallView.speed - 8;

		} else if (Carrace2Activity.status == 1 & BallView.speed < 70)
			
		{

			BallView.speed = BallView.speed + 4;

		} else if (BallView.speed < 10 & Carrace2Activity.status == 0)
		{

			BallView.speed = 10;
		}

	}
	
	

}