package com.techpalle.listviewexp1;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //declare all variable
    EditText et;
    Button b;
    ListView lv;
    ArrayList<String>a1;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText1);
        b=(Button)findViewById(R.id.button1);
        lv=(ListView)findViewById(R.id.listview1);
        a1=new ArrayList<String>();
       // aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a1);
        aa=new ArrayAdapter<String>(this,R.layout.row,a1);
        //above line establish connection between arraylist to arrya adaptor.
        //adaptor funcitonality
        //1-read data from src,2-load xml and load view,3-fill data on to view,4-
        //establish connection between array adapter to listview
        lv.setAdapter(aa);
        //implement list view item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //3rd parameter is important -position ot the element
               // Toast.makeText(MainActivity.this,"position.."+i,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"position.."+a1.get(i),Toast.LENGTH_SHORT).show();
            }
        });
        //implement button click listener -to add elemtnet  to arraylist

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String city=et.getText().toString().trim();//read city from edittext
                if(city.isEmpty()){
                    return;
                }
                a1.add(city);//add city  to source(array list)
                Collections.sort(a1);
                aa.notifyDataSetChanged();//tell to adapter
                //now clean edit text
                et.setText("");
                et.requestFocus();
            }
        });

    }
}
