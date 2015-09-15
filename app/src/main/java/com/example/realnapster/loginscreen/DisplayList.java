package com.example.realnapster.loginscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {
    //Create Text Object
    TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        //Create Shared preference Object
        SharedPreferences prefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String uname=prefs.getString("uname","");
        String pword=prefs.getString("pwd", "");
        //Shows  logs in logcat
        Log.d("Shared Pref Value:", uname);
        Log.d("Shared Pref Value:", pword);
        tview=(TextView)findViewById(R.id.textpref);
        tview.setText("Username="+uname+"\nPassword="+pword);
        final ListView listView=(ListView)findViewById(R.id.lst);
        String[] country = new String[] { "Nepal",
                "Belgium",
                "Argentina",
                "England",
                "Canada",
                "Cuba",
                "America",
                "Australia",
                "New Zealand",
                "South Africa",
                "Mexico",
                "Russia",
                "Ireland",
                "Japan"
        };
        final ArrayList<String> list=new ArrayList<>();
        for (String i:country){
            System.out.println(i);
            list.add(i);
        }

         /* Defining new array adapter, with parameters 1)Context
        2)Layout for the row,
        3)Id of textview for which data is written
        4)The array of data
        Adapters are used to provide the data to the ListView
        Parameters:
        simple_list_item_1 :  Android internal layout view
        android.R.id.text1 :  In Android internal layout view already defined text fields to show data
        values             :  User defined data array.
         */
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        //Assign adapter lo ListView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue=(String)listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Position:" + position + "\nList item:" + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_list, menu);
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
