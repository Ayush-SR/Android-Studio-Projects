package in.desd.day5app1activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Button bt1;
    TextView tv;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);
        Log.d("ALC","in onCreate()");

        tv=(TextView)findViewById(R.id.idTextView);
        bt1=(Button)findViewById(R.id.idButton);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count ="count"+(i++);
                tv.setText(count);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC","in onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC","in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC","in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC","in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC","in onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ALC","in onRestart()");
    }
}
