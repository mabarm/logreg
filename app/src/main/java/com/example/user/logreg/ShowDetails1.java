package com.example.user.logreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ShowDetails1 extends AppCompatActivity {
    private EditText det1a,det2a,det3a,det4a,det5a,det6a,det7a,det8a,det9a,det10a,det11a,det12a,det13a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details1);
        Bundle bundle = getIntent().getExtras();
        String text1= bundle.getString("one");
        String text2= bundle.getString("two1");
        String text3= bundle.getString("two2");
        String text4= bundle.getString("two3");
        String text5= bundle.getString("two4");
        String text6= bundle.getString("two5");
        String text7= bundle.getString("two6");
        String text8= bundle.getString("two7");
        String text9= bundle.getString("two8");
        String text10= bundle.getString("two9");
        String text11= bundle.getString("two10");
        String text12= bundle.getString("two11");
        String text13= bundle.getString("two12");


        det1a=(EditText)findViewById(R.id.det1a);
        det2a=(EditText)findViewById(R.id.det2a);
        det3a=(EditText)findViewById(R.id.det3a);
        det4a=(EditText)findViewById(R.id.det4a);
        det5a=(EditText)findViewById(R.id.det5a);
        det6a=(EditText)findViewById(R.id.det6a);
        det7a=(EditText)findViewById(R.id.det7a);
        det8a=(EditText)findViewById(R.id.det8a);
        det9a=(EditText)findViewById(R.id.det9a);
        det10a=(EditText)findViewById(R.id.det10a);
        det11a=(EditText)findViewById(R.id.det11a);
        det12a=(EditText)findViewById(R.id.det12a);
        det13a=(EditText)findViewById(R.id.det13a);



        if (det1a!= null) {
            det1a.setText("Employee No: " + String.valueOf(text1));

        }
        if (det2a != null) {
            det2a.setText("Employee Name: "+ String.valueOf(text2));

        }
        if (det3a != null) {
            det3a.setText("Designation: " +String.valueOf(text3));

        }
        if (det4a != null) {
            det4a.setText("Grade: "+ String.valueOf(text4));

        }
        if (det5a != null) {
            det5a.setText("Section: "+ String.valueOf(text5));

        }
        if (det6a != null) {
            det6a.setText("Remarks: "+ String.valueOf(text6));

        }
        if (det7a != null) {
            det7a.setText("Dept: "+ String.valueOf(text7));

        }
        if (det8a != null) {
            det8a.setText("Contact No: "+ String.valueOf(text8));

        }
        if (det9a != null) {
            det9a.setText("Quarter No: "+ String.valueOf(text9));

        }
        if (det10a != null) {
            det10a.setText("Member Name: "+ String.valueOf(text10));

        }
        if (det11a != null) {
            det11a.setText("Member DOB: "+ String.valueOf(text11));

        }
        if (det12a != null) {
            det12a.setText("Member Relation: "+ String.valueOf(text12));

        }
        if (det13a != null) {
            det12a.setText("Swimming Level: "+ String.valueOf(text12));

        }



    }

}
