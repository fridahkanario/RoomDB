package com.example.roomdb;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSave;
    EditText inputName;
    EditText inputAge;
    TextView txtRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSave =findViewById(R.id.save);
        inputName =findViewById(R.id.name);
        inputAge =findViewById(R.id.age);
        txtRecords=findViewById(R.id.textrecords);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save();
            }
        });






        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              save();
            }
        });
    }

    private void save() {
        String names=inputName.getText().toString().trim();
        String age_string=inputAge.getText().toString().trim();
        if (names.isEmpty() || age_string.isEmpty()){
            Toast.makeText(this, "Please fill all spaces", Toast.LENGTH_SHORT).show();
            return;
        }

        int age=Integer.parseInt(age_string);
        UserActivity x=new UserActivity();
        x.setName(names);
        x.setAge(age);



        MyDatabase.getInstance(this).getUserDao().insertUser(x);


        int count=MyDatabase.getInstance(this).getUserDao().getCount();

        txtRecords.setText(count+"");
        inputName.setText("");
        inputAge.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
