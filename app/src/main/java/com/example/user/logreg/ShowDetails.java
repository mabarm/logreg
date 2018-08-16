package com.example.user.logreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ShowDetails extends AppCompatActivity {
private EditText det1,det2,det3,det4,det5,det6,det7,det8,det9,det10,det11,det12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
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

         det1=(EditText)findViewById(R.id.det1);
         det2=(EditText)findViewById(R.id.det2);
         det3=(EditText)findViewById(R.id.det3);
         det4=(EditText)findViewById(R.id.det4);
         det5=(EditText)findViewById(R.id.det5);
         det6=(EditText)findViewById(R.id.det6);
         det7=(EditText)findViewById(R.id.det7);
         det8=(EditText)findViewById(R.id.det8);
        det9=(EditText)findViewById(R.id.det9);
         det10=(EditText)findViewById(R.id.det10);
         det11=(EditText)findViewById(R.id.det11);
        det12=(EditText)findViewById(R.id.det12);

        if (det1 != null) {
            det1.setText("Employee No: " + String.valueOf(text1));

        }
        if (det2 != null) {
            det2.setText("Employee Name: "+ String.valueOf(text2));

        }
        if (det3 != null) {
            det3.setText("Designation: " +String.valueOf(text3));

        }
        if (det4!= null) {
            det4.setText("Dept: "+ String.valueOf(text4));

        }
        if (det5 != null) {
            det5.setText("Grade: "+ String.valueOf(text5));

        }
        if (det6 != null) {
            det6.setText("Req No: "+ String.valueOf(text6));

        }
        if (det7 != null) {
            det7.setText("Req Date: "+ String.valueOf(text7));

        }
        if (det8 != null) {
            det8.setText("No of Days "+ String.valueOf(text8));

        }
        if (det9 != null) {
            det9.setText("Booking Fee: "+ String.valueOf(text9));

        }
        if (det10 != null) {
            det10.setText("Quarter No: "+ String.valueOf(text10));

        }
        if (det11 != null) {
            det11.setText("Contact No: "+ String.valueOf(text11));

        }
        if (det12 != null) {
            det12.setText("Pincode: "+ String.valueOf(text12));

        }




    }
}
