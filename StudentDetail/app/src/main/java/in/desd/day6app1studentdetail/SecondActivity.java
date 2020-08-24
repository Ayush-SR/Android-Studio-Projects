package in.desd.day6app1studentdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {     //FirstActivity--child class
                                                            //AppCompatActivity--parent class

    TextView Name2,C2,Cpp2,Java2;
    EditText Feedback2;
    Button back;
    float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        Name2=(TextView)findViewById(R.id.idName2);
        C2=(TextView)findViewById(R.id.idC);
        Cpp2=(TextView)findViewById(R.id.idCpp);
        Java2=(TextView)findViewById(R.id.idJava);
        Feedback2=(EditText)findViewById(R.id.idFeedback);
        back=(Button)findViewById(R.id.idBack);

        addBackBtnListener();

        Intent recIntent;
        recIntent=getIntent();
        String name=recIntent.getStringExtra("KEY NAME");
        Bundle bundle1=recIntent.getExtras();
        float cm=bundle1.getFloat("KEY C");
        float cppm=bundle1.getFloat("KEY CPP");
        float jm=bundle1.getFloat("KEY JAVA");

        total=cm+cppm+jm;

        Name2.setText("Name:"+name);
        C2.setText(""+cm);
        Cpp2.setText(""+cppm);
        Java2.setText(""+jm);

    }//end of onCreate

    private void addBackBtnListener()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retIntent=new Intent();      //this intent will target to the calling activity
                String fb=Feedback2.getText().toString();
                retIntent.putExtra("KEY_FB",fb);
                retIntent.putExtra("KEY_TOTAL",total);
                setResult(RESULT_OK,retIntent);
                SecondActivity.this.finish();
            }
        });
    }
}
