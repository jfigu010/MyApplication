package com.example.jose.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class question2 extends ActionBarActivity {

    double alphavalue = 0;
    double betavalue = 0;
    double p1satvalue = 0;
    double p2satvalue = 0;
    double score = 0;
    double xy = 0.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    public void onButtonClick(View v){
        EditText tsys = (EditText)findViewById(R.id.editText10);
        EditText psys = (EditText)findViewById(R.id.editText11);
        TextView t1 = (TextView)findViewById(R.id.textView43);
        TextView t2 = (TextView)findViewById(R.id.textView44);
        TextView t3 = (TextView)findViewById(R.id.textView45);
        TextView t4 = (TextView)findViewById(R.id.textView46);
        TextView t5 = (TextView)findViewById(R.id.textView6);
        TextView t6 = (TextView)findViewById(R.id.textView7);
        double t = Double.parseDouble(tsys.getText().toString());
        p1satvalue = Math.pow(10,7 - (1200/(t+220)));
        String p1satvalueout = String.format("%.2f", p1satvalue);
        p2satvalue = Math.pow(10,8 - (1600/(t+225)));
        String p2satvalueout = String.format("%.2f", p2satvalue);
        double p = Double.parseDouble(psys.getText().toString());
        double gamma1az = p*xy/(xy*p1satvalue);
        String gamma1azout = String.format("%.2f", gamma1az);
        double gamma2az = p*xy/(xy*p2satvalue);
        String gamma2azout = String.format("%.2f", gamma2az);
        alphavalue = Math.log(gamma1az)*Math.pow((1+((Math.log(gamma2az)*xy)/(xy*Math.log(gamma1az)))),2);
        String alphavalueout = String.format("%.2f", alphavalue);
        betavalue = Math.log(gamma2az)*Math.pow((1+((xy*Math.log(gamma1az))/(xy*Math.log(gamma2az)))),2);
        String betavalueout = String.format("%.3f", betavalue);
        t1.setText(p1satvalueout);
        t2.setText(p2satvalueout);
        t3.setText(gamma1azout);
        t4.setText(gamma2azout);
        t5.setText(alphavalueout);
        t6.setText(betavalueout);

        if (alphavalueout == "12.84" && betavalueout == "0.790"){
            score = score + 40;
        }
    }

    public void onButtonClick2(View v){
        EditText e4 = (EditText) findViewById(R.id.editText13);
        /*String input = e4.getText().toString();
        if (input.equals(""));
            break;
        }*/
        TextView t1 = (TextView)findViewById(R.id.textView47);
        TextView t2 = (TextView)findViewById(R.id.textView48);
        TextView t3 = (TextView)findViewById(R.id.textView8);
        TextView t4 = (TextView)findViewById(R.id.textView9);
        TextView t5 = (TextView)findViewById(R.id.textView10);
        double x1 = Double.parseDouble(e4.getText().toString());
        double x2 = 1-x1;
        double gamma1 = Math.exp(alphavalue / Math.pow(1 + ((alphavalue * x1) / (betavalue * x2)), 2));
        String gamma1out = String.format("%.2f", gamma1);
        double gamma2 = Math.exp(betavalue/Math.pow(1 + ((betavalue * x2) / (alphavalue * x1)), 2));
        String gamma2out = String.format("%.2f", gamma2);
        double p1 = p1satvalue*x1*gamma1;
        double p2 = p2satvalue*x2*gamma2;
        double ptotal = p1+p2;
        String ptotalout = String.format("%.2f", ptotal);
        double y1 = p1/ptotal;
        String y1out = String.format("%.2f", y1);
        double y2 = 1-y1;
        String y2out = String.format("%.2f", y2);
        t1.setText(gamma1out);
        t2.setText(gamma2out);
        t3.setText(ptotalout);
        t4.setText(y1out);
        t5.setText(y2out);

        TextView t10 = (TextView) findViewById(R.id.textView50);
        boolean isChecked = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        if (isChecked) {
            score = score + 20;
        }
        if (ptotalout == "737.68" && y1out == "0.89" && y2out == "0.11"){
            score = score + 40;
        }
        String scoreout =  Double.toString(score);
        t10.setText(scoreout);
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
