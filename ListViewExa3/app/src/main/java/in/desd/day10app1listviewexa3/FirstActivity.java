package in.desd.day10app1listviewexa3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class FirstActivity extends AppCompatActivity {

    EditText etName,etRollNo;
    Button btAdd;
    ListView lvList;
    ArrayAdapter<Student> adapter;
    ArrayList<Student> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);
        etName=(EditText)findViewById(R.id.idEditName);
        etRollNo=(EditText)findViewById(R.id.idEditRollNo);
        btAdd=(Button)findViewById(R.id.idBtnAdd);
        lvList=(ListView)findViewById(R.id.idListView);

        al=new ArrayList<Student>();
        adapter=new ArrayAdapter<Student>(
          FirstActivity.this,
          android.R.layout.simple_list_item_1,
          al
        );

        lvList.setAdapter(adapter);
        addBtnListener();
    }

    private void addBtnListener(){
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                int rollNo=Integer.parseInt(etRollNo.getText().toString());

                Student st=new Student(name,rollNo);
                al.add(st);
                adapter.notifyDataSetChanged();

                etName.setText("");
                etRollNo.setText("");
            }
        });
    }
}

