package com.example;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
	  private SensorManager mSensorManager;
	  private Sensor mAccelerometer;

	  TextView title,tv,tv1,tv2;
	  RelativeLayout layout;
	  
	  @Override
	  public final void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    
	    //get layout
	    layout = (RelativeLayout)findViewById(R.id.relative);
	    
	    //get textviews
	    title=(TextView)findViewById(R.id.name);   
	    tv=(TextView)findViewById(R.id.xval);
	    tv1=(TextView)findViewById(R.id.yval);
	    tv2=(TextView)findViewById(R.id.zval);
	   	    
		
	  }

	  @Override
	  public final void onAccuracyChanged(Sensor sensor, int accuracy)
	  {
	    // Do something here if sensor accuracy changes.
	  }

	  @Override
	  public final void onSensorChanged(SensorEvent event) 
	  {
	    // Many sensors return 3 values, one for each axis.
	    float x =  event.values[0];
	    float y =  event.values[1];
	    float z =  event.values[2];
	  
	    
	    //display values using TextView
	    title.setText(R.string.app_name);
	    tv.setText("X axis" +"\t\t"+x);
	    tv1.setText("Y axis" + "\t\t" +y);
	    tv2.setText("Z axis" +"\t\t" +z);
	    
	  }

	  @Override
	  protected void onResume()
	  {
	    super.onResume();
	    mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    mSensorManager.unregisterListener(this);
	  }
	}