package in.desd.day10app3sensorexa2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tvX,tvY,tvZ,tvDist;
    SensorManager sensorManager;
    Sensor sensorAcc;
    Sensor sensorPro;
    LinearLayout llBackground;
    PowerManager powerManager;
    PowerManager.WakeLock wakelock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvX=(TextView)findViewById(R.id.idTextX);
        tvY=(TextView)findViewById(R.id.idTextY);
        tvZ=(TextView)findViewById(R.id.idTextZ);
        tvDist=(TextView)findViewById(R.id.idTextDist);
        llBackground=(LinearLayout)findViewById(R.id.idBackground);
        powerManager=(PowerManager)getSystemService(POWER_SERVICE);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorAcc=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorPro=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }//end of onCreate

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(
                this,
                sensorAcc,
                SensorManager.SENSOR_DELAY_NORMAL
        );

        sensorManager.registerListener(
                this,
                sensorPro,
                SensorManager.SENSOR_DELAY_NORMAL
        );

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
            int dist=(int)event.values[0];
            tvDist.setText("Dist:"+dist);

           if(dist<sensorPro.getMaximumRange()){
               wakelock=powerManager.newWakeLock(
                       PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK,
                       "on"
                       );
               wakelock.acquire();


             // llBackground.setBackgroundColor(Color.WHITE);
            }
            else{
               wakelock=powerManager.newWakeLock(
                       PowerManager.SCREEN_BRIGHT_WAKE_LOCK,
                       "off"
               );
              //  llBackground.setBackgroundColor(Color.GRAY);
            }
        }

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            tvX.setText("X:" + x);
            tvY.setText("Y:" + y);
            tvZ.setText("Z:" + z);
            if (x > 5 && x < 9) {
                tvX.setTextColor(Color.RED);
            } else
                tvX.setTextColor(Color.GRAY);

            if (y > 5 && y < 9) {
                tvY.setTextColor(Color.GREEN);
            } else
                tvY.setTextColor(Color.GRAY);

            if (z > 5 && z < 9) {
                tvZ.setTextColor(Color.MAGENTA);
            } else
                tvZ.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
