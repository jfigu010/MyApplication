package com.example.jose.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class question2 extends ActionBarActivity {

    double alphavalue = 0;
    double betavalue = 0;
    double p1satvalue = 0;
    double p2satvalue = 0;
    double xy = 0.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    public void onButtonClick(View v){
        EditText tsys = (EditText)findViewById(R.id.editText10);
        EditText psys = (EditText)findViewById(R.id.editText11);
        TextView t1 = (TextView)findViewById(R.id.textView6);
        TextView t2 = (TextView)findViewById(R.id.textView7);
        double t = Double.parseDouble(tsys.getText().toString());
        p1satvalue = Math.pow(10,7 - (1200/(t+220)));
        p2satvalue = Math.pow(10,8 - (1600/(t+225)));
        double p = Double.parseDouble(psys.getText().toString());
        double gamma1az = p*xy/(xy*p1satvalue);
        double gamma2az = p*xy/(xy*p2satvalue);
        alphavalue = Math.log(gamma1az)*Math.pow((1+((Math.log(gamma2az)*xy)/(xy*Math.log(gamma1az)))),2);
        String alphavalueout = String.format("%.2f", alphavalue);
        betavalue = Math.log(gamma2az)*Math.pow((1+((xy*Math.log(gamma1az))/(xy*Math.log(gamma2az)))),2);
        String betavalueout = String.format("%.3f", betavalue);
        t1.setText(alphavalueout);
        t2.setText(betavalueout);
    }
    public void onButtonClick2(View v){
        EditText e4 = (EditText) findViewById(R.id.editText13);
        TextView t3 = (TextView)findViewById(R.id.textView8);
        TextView t4 = (TextView)findViewById(R.id.textView9);
        TextView t5 = (TextView)findViewById(R.id.textView10);
        double x1 = Double.parseDouble(e4.getText().toString());
        double x2 = 1-x1;
        double gamma1 = Math.exp(alphavalue / Math.pow(1 + ((alphavalue * x1) / (betavalue * x2)), 2));
        double gamma2 = Math.exp(betavalue/Math.pow(1 + ((betavalue * x2) / (alphavalue * x1)), 2));
        double p1 = p1satvalue*x1*gamma1;
        double p2 = p2satvalue*x2*gamma2;
        double totalp = p1+p2;
        String totalpout = String.format("%.2f", totalp);
        double y1 = p1/totalp;
        String y1out = String.format("%.2f", y1);
        double y2 = 1-y1;
        String y2out = String.format("%.2f", y2);
        t3.setText(totalpout);
        t4.setText(y1out);
        t5.setText(y2out);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question2, menu);
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
