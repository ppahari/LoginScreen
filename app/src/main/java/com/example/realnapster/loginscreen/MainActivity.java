package com.example.realnapster.loginscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;
    public final String MyPreferences="MyPref";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editUname);
        ed2=(EditText)findViewById(R.id.editPwd);
        b1=(Button)findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref=getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

                if (ed1.getText().toString().equals("admin")&& ed2.getText().toString().equals("pwd")){
                    SharedPreferences.Editor editor=sharedPref.edit();
                    editor.putString("uname",ed1.getText().toString());
                    editor.putString("pwd", ed2.getText().toString());
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Redirecting..", Toast.LENGTH_SHORT).show();
                    //Create new Intent Here
                    Intent intent = new Intent(MainActivity.this ,DisplayList.class);
                    startActivity(intent);
                }
                    else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }




            }
        });


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
