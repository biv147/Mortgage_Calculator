package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView txtresult;
    EditText txtamount;
    EditText txtprin;
    EditText txtinterest;
    Button btncalculate;

    double principle;
    double amount;
    double interest;
    double result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intializing all the edit text
        txtprin = (EditText) findViewById(R.id.txtPrin);
        txtamount = (EditText) findViewById(R.id.txtAmount);
        txtinterest = (EditText) findViewById(R.id.txtInterest);

        //intializing the button
        btncalculate = (Button) findViewById(R.id.btnCal);

        //intializing the reuslt textview
        txtresult = (TextView) findViewById(R.id.txtResult);

        //method that would calculate the mortgage when the button is pressed
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting the values of the edit texts
                principle = Double.parseDouble(txtprin.getText().toString());
                interest = Double.parseDouble(txtinterest.getText().toString());
                amount = Double.parseDouble(txtamount.getText().toString());

                //converting user inputs to put into the formula
                interest = (interest/100)/12;
                amount = amount * 12;

                //calculating the mortgage
                double tophalf = principle * interest * Math.pow((1+interest),amount);
                double bottomhalf = Math.pow((1+interest),amount) - 1;
                result = tophalf/bottomhalf;

                //formatting the result
                String finalResult = String.valueOf(new DecimalFormat("##.##").format(result));

                //sending the result to the textview to show the user
                txtresult.setText("$ "+finalResult);
            }
        });
    }
}