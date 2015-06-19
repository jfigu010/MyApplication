package com.example.jose.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Question1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question1, menu);
        return true;
    }


    public void onButtonClick3(View v){
        EditText h = (EditText) findViewById(R.id.editText);
        EditText p2s = (EditText) findViewById(R.id.editText2);
        EditText p = (EditText) findViewById(R.id.editText5);
        TextView t6 = (TextView)findViewById(R.id.textView13);
        TextView t7 = (TextView)findViewById(R.id.textView14);
        TextView t8 = (TextView)findViewById(R.id.textView15);
        TextView t9 = (TextView)findViewById(R.id.textView16);
        double h1 = Double.parseDouble(h.getText().toString());
        double p2sat = Double.parseDouble(p2s.getText().toString());
        double ptot = Double.parseDouble(p.getText().toString());
        double x1 = ptot/h1;
        String x1out = String.format("%.3f", x1);
        double x2 = 1-x1;
        String x2out = String.format("%.3f", x2);
        double y2 = p2sat*x2/ptot;
        String y1out = String.format("%.4f", y2);
        double y1 = 1-y2;
        String y2out = String.format("%.4f", y1);
        t6.setText(x1out);
        t7.setText(x2out);
        t8.setText(y1out);
        t9.setText(y2out);
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
