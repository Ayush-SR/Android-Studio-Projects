package in.desd.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 TextView result2;
 Button back;
float res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        result2=(TextView)findViewById(R.id.idResult2);
        back=(Button)findViewById(R.id.idBack);

        Intent recIntent=getIntent();

        //---------------------------------------older approach---------------------------
        /* String m1=recIntent.getStringExtra("KEY");
        result2.setText(" "+m1);*/

        //---------------------------------------newer approach---------------------------
        Bundle bundle1=recIntent.getExtras();
        float a=bundle1.getFloat("KEY_IP1");
        float b=bundle1.getFloat("KEY_IP2");
        String op=bundle1.getString("KEY_MSG");

        if(op.equals("+"))
        {
             res=a+b;
            result2.setText(" "+res);
        }
        if(op.equals("-"))
        {
             res=a-b;
            result2.setText(" "+res);
        }
        if(op.equals("*"))
        {
             res=a*b;
            result2.setText(" "+res);
        }
        if(op.equals("/"))
        {
             res=a/b;
            result2.setText(" "+res);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retintent=new Intent();
                Float m2=Float.parseFloat(result2.getText().toString());
                retintent.putExtra("KEY_BACK",m2);
                setResult(RESULT_OK,retintent);
                SecondActivity.this.finish();
            }
        });
    }
}

