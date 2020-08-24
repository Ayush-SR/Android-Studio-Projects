package in.desd.day11app4broadcastrecexa4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView tvHeadSetStatus,tvBatteryInfo;
    ImageView imgBattery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);

        tvHeadSetStatus=(TextView)findViewById(R.id.idTextStatus);
        tvBatteryInfo=(TextView)findViewById(R.id.iDTextBattery);
        imgBattery=(ImageView)findViewById(R.id.idImageBattery);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiverHeadSet,new IntentFilter(Intent.ACTION_HEADSET_PLUG));
        registerReceiver(receiverBattery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiverHeadSet);
        unregisterReceiver(receiverBattery);
    }

    BroadcastReceiver receiverHeadSet=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {

                int status = intent.getIntExtra("state", 0);

                if (status == 0) {
                    tvHeadSetStatus.setText("HeadSet Status:unPlugged");
                    tvHeadSetStatus.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                } else {
                    tvHeadSetStatus.setText("Headset Status:Plugged");
                    tvHeadSetStatus.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }
            }
        }
    };

    BroadcastReceiver receiverBattery=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
            {
                int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);

                int icon=intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0);
                imgBattery.setImageResource(icon);

                StringBuffer stringBuffer=new StringBuffer();//it is a mutable string
                stringBuffer.append("Battery Info:\n");

                if(status==BatteryManager.BATTERY_STATUS_CHARGING){
                    stringBuffer.append("Battery Charging\n");
                }
                else if(status==BatteryManager.BATTERY_STATUS_DISCHARGING){
                    stringBuffer.append("Battery not Charging\n");
                }
                else{
                    stringBuffer.append("Battery not available\n");
                }
                tvBatteryInfo.setText(stringBuffer);

            }
        }
    };

}
