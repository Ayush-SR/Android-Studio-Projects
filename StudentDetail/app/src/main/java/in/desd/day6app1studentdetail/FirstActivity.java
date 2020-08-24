package in.desd.day6app1studentdetail;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.floatToIntBits;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class FirstActivity extends AppCompatActivity {

    EditText Name,C,Cpp,java,Total,Feedback;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);

        Name=(EditText)findViewById(R.id.idName);
        C=(EditText) findViewById(R.id.idCM);
        Cpp=(EditText) findViewById(R.id.idCppM);
        java=(EditText)findViewById(R.id.idJavaM);
        Total=(EditText)findViewById(R.id.idTotal1);
        Feedback=(EditText)findViewById(R.id.idFeedback1);

        Submit=(Button)findViewById(R.id.idSubmit);

        addSubmitBtnListner();
        Toast.makeText();
    }//end of onCreate
    private void addSubmitBtnListner()
    {
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(
                        FirstActivity.this,
                        SecondActivity.class
                );*/

               //impicit intent

               Intent intent=new Intent("myaction1");

                String name=Name.getText().toString();
                intent.putExtra("KEY NAME",name);
                float CMarks=Float.parseFloat(C.getText().toString());
                float CppMarks=Float.parseFloat(Cpp.getText().toString());
                float Java=Float.parseFloat(java.getText().toString());

                Bundle bundle=new Bundle();

                bundle.putFloat("KEY C",CMarks);
                bundle.putFloat("KEY CPP",CppMarks);
                bundle.putFloat("KEY JAVA",Java);

                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,11);

            }

        });
    }//end of method addSubmit

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11 && resultCode==RESULT_OK) {

            String feedback = data.getStringExtra("KEY_FB");
            float total=data.getFloatExtra("KEY_TOTAL",0);

            Feedback.setTextColor(Color.RED);
            Total.setTextColor(Color.RED);
            Feedback.setText("Feedback:"+feedback);
            Total.setText("Total:"+total);
        }
    }//end of the method

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //int var1;
        if(keyCode==KeyEvent.KEYCODE_BACK){
            return true;
        }

        return super.onKeyDown(keyCode, event);

    }
}
