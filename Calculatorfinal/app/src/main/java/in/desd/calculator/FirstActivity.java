package in.desd.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText Input1, Input2;
    Button plus, minus, mul, div;
    TextView result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);

        Input1 = (EditText) findViewById(R.id.idInput1);
        Input2 = (EditText) findViewById(R.id.idInput2);
        plus = (Button) findViewById(R.id.idPlus);
        minus = (Button) findViewById(R.id.idMinus);
        mul = (Button) findViewById(R.id.idMul);
        div = (Button) findViewById(R.id.idDiv);
        result1 = (TextView) findViewById(R.id.idResult);

        /*plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent("myaction2");
                String a = Input1.getText().toString();
                String b = Input2.getText().toString();

                int add = Integer.parseInt(a) + Integer.parseInt(b);
                String result = " " + add + " ";
                intent1.putExtra("KEY", result);
                startActivityForResult(intent1, 11);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent("myaction2");
                String a = Input1.getText().toString();
                String b = Input2.getText().toString();

                int sub = Integer.parseInt(a) - Integer.parseInt(b);
                String result = " " + sub + " ";
                intent2.putExtra("KEY", result);
                startActivityForResult(intent2, 11);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent("myaction2");
                String a = Input1.getText().toString();
                String b = Input2.getText().toString();

                int mul = Integer.parseInt(a) * Integer.parseInt(b);
                String result = " " + mul + " ";
                intent3.putExtra("KEY", result);
                startActivityForResult(intent3, 11);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent("myaction2");
                String a = Input1.getText().toString();
                String b = Input2.getText().toString();

                int div = Integer.parseInt(a) / Integer.parseInt(b);
                String result = " " + div + " ";
                intent4.putExtra("KEY", result);
                startActivityForResult(intent4, 11);
            }
        });*/
    }//end od Oncreate



    public void onplus(View view) {
    Intent intent1 =new Intent("action2");
        float a = Float.parseFloat(Input1.getText().toString());
        float b = Float.parseFloat(Input2.getText().toString());

        Bundle bundle=new Bundle();

        bundle.putFloat("KEY_IP1",a);
        bundle.putFloat("KEY_IP2",b);
        bundle.putString("KEY_MSG","+");
        intent1.putExtras(bundle);

        startActivityForResult(intent1,11);
        }

    public void onminus(View view) {
        Intent intent2 =new Intent("action2");
        float a = Float.parseFloat(Input1.getText().toString());
        float b = Float.parseFloat(Input2.getText().toString());

        Bundle bundle=new Bundle();

        bundle.putFloat("KEY_IP1",a);
        bundle.putFloat("KEY_IP2",b);
        bundle.putString("KEY_MSG","-");
        intent2.putExtras(bundle);

        startActivityForResult(intent2,12);
    }

    public void onmul(View view) {
        Intent intent3 =new Intent("action2");
        float a = Float.parseFloat(Input1.getText().toString());
        float b = Float.parseFloat(Input2.getText().toString());

        Bundle bundle=new Bundle();

        bundle.putFloat("KEY_IP1",a);
        bundle.putFloat("KEY_IP2",b);
        bundle.putString("KEY_MSG","*");
        intent3.putExtras(bundle);

        startActivityForResult(intent3,13);
    }

    public void ondiv(View view) {
        Intent intent4 =new Intent("action2");
        float a = Float.parseFloat(Input1.getText().toString());
        float b = Float.parseFloat(Input2.getText().toString());

        Bundle bundle=new Bundle();

        bundle.putFloat("KEY_IP1",a);
        bundle.putFloat("KEY_IP2",b);
        bundle.putString("KEY_MSG","/");
        intent4.putExtras(bundle);

        startActivityForResult(intent4,14);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK) {

            float feedback = data.getFloatExtra("KEY_BACK",0);
            result1.setText(" "+feedback+" ");
        }
        if (requestCode == 12 && resultCode == RESULT_OK)
        {
            float feedback = data.getFloatExtra("KEY_BACK",0);
            result1.setText(" "+feedback+" ");
        }
        if (requestCode == 13 && resultCode == RESULT_OK)
        {
            float feedback = data.getFloatExtra("KEY_BACK",0);
            result1.setText(" "+feedback+" ");
        }
        if (requestCode == 14 && resultCode == RESULT_OK)
        {
            float feedback = data.getFloatExtra("KEY_BACK",0);
            result1.setText(" "+feedback+" ");
        }
    }
}
