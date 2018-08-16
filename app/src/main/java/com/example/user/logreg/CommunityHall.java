package com.example.user.logreg;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CommunityHall extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] Select_Purpose= { "vacation","Knowledgeable conference","Family time plus vacation"};
    private TextView startDateDisplay;
    private TextView endDateDisplay;

    private Calendar startDate;
    private Calendar endDate;
    static final int DATE_DIALOG_ID = 0;

    private TextView activeDateDisplay;
    private Calendar activeDate;
    private EditText ref;
    private long daysDiff,msDiff,bookfee;
    private EditText nod,ebookfee;

    private EditText empname, empno, desg, grade, reqno, reqdate, dept, contno, quarno, email, pincode;
    private Button submit,submit12;
    private DatabaseReference mDatabaseMultipleVals;
    private FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_hall);

         EditText ref=(EditText)findViewById(R.id.ref);
        if (ref != null) {
            ref.setEnabled(false);
        }
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        if (spin != null) {
            spin.setOnItemSelectedListener(this);
        }
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Select_Purpose);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        if (spin != null) {
            spin.setAdapter(aa);
        }
         /*  capture our View elements for the start date function   */
        startDateDisplay = (TextView) findViewById(R.id.startDateDisplay);


        /* get the current date */
        startDate = Calendar.getInstance();

        /* add a click listener to the button   */
        if (startDateDisplay != null){
        startDateDisplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog(startDateDisplay, startDate);
            }
        });}

        /* capture our View elements for the end date function */
        endDateDisplay = (TextView) findViewById(R.id.endDateDisplay);


        /* get the current date */
        endDate = Calendar.getInstance();

        /* add a click listener to the button   */
        if (endDateDisplay!= null){
        endDateDisplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog(endDateDisplay, endDate);
            }
        });}

        /* display the current date (this method is below)  */
        updateDisplay(startDateDisplay, startDate);
        updateDisplay(endDateDisplay, endDate);

        submit12=(Button) findViewById(R.id.submit12);
        empname = (EditText) findViewById(R.id.empname);
        empno = (EditText) findViewById(R.id.empno);
        desg = (EditText) findViewById(R.id.desg);
        grade = (EditText) findViewById(R.id.grade);
        reqno = (EditText) findViewById(R.id.reqno);
        reqdate = (EditText) findViewById(R.id.reqdate);
        dept = (EditText) findViewById(R.id.dept);
        contno = (EditText) findViewById(R.id.contno);
        quarno = (EditText) findViewById(R.id.quarno);
        nod = (EditText) findViewById(R.id.nod);
        ebookfee = (EditText) findViewById(R.id.ebookfee);
       if (nod != null) {
            nod.setEnabled(false);
        }

        if (ebookfee != null) {
            ebookfee.setEnabled(false);
        }
        email = (EditText) findViewById(R.id.emaill);
        pincode = (EditText) findViewById(R.id.pincode);
        submit = (Button) findViewById(R.id.submit);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(submit!=null) {
            submit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (user != null)

                        mDatabaseMultipleVals = FirebaseDatabase.getInstance().getReferenceFromUrl("https://logreg-8fb1c.firebaseio.com/Community Hall");

                    String eno = empno.getText().toString().trim();
                    String ename = empname.getText().toString().trim();
                    String edesg = desg.getText().toString().trim();
                    String edept = dept.getText().toString().trim();
                    String ereqno = reqno.getText().toString().trim();
                    String ereqdate = reqdate.getText().toString().trim();
                    String econtno = contno.getText().toString().trim();
                    String equarno = quarno.getText().toString().trim();
                    String egrade = grade.getText().toString().trim();
                    String editemail = email.getText().toString().trim();
                    String epincode = pincode.getText().toString().trim();
                    String enod = nod.getText().toString().trim();
                   String editbookfee = ebookfee.getText().toString().trim();


                    if (TextUtils.isEmpty(eno)) {
                        Toast.makeText(CommunityHall.this, "Please enter employee no", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(ename)) {
                        Toast.makeText(CommunityHall.this, "Please enter employee name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edesg)) {
                        Toast.makeText(CommunityHall.this, "Please enter designation ", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edept)) {
                        Toast.makeText(CommunityHall.this, "Please enter department", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(ereqno)) {
                        Toast.makeText(CommunityHall.this, "Please enter requisition no", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(ereqdate)) {
                        Toast.makeText(CommunityHall.this, "Please enter requisition date", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(econtno)) {
                        Toast.makeText(CommunityHall.this, "Please enter contact no", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(equarno)) {
                        Toast.makeText(CommunityHall.this, "Please enter quarter no", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(egrade)) {
                        Toast.makeText(CommunityHall.this, "Please enter grade", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(editemail)) {
                        Toast.makeText(CommunityHall.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(epincode)) {
                        Toast.makeText(CommunityHall.this, "Please enter pincode", Toast.LENGTH_SHORT).show();
                    }
                    // We can safely insert data into our firebase database
                    else {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("Employee No", empno.getText().toString());
                        hashMap.put("Employee Name", empname.getText().toString());
                        hashMap.put("Designation", desg.getText().toString());
                        hashMap.put("Department", dept.getText().toString());
                        hashMap.put("Grade", grade.getText().toString());
                        hashMap.put("Pincode", pincode.getText().toString());
                        hashMap.put("Contact No", contno.getText().toString());
                        hashMap.put("Quarter No", quarno.getText().toString());
                        hashMap.put("Requisition No", reqno.getText().toString());
                        hashMap.put("Requisition Date", reqdate.getText().toString());
                        hashMap.put("Booking Fees", ebookfee.getText().toString());
                        hashMap.put("No of Days", nod.getText().toString());


                        mDatabaseMultipleVals.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(CommunityHall.this, "User data successfully saved.", Toast.LENGTH_SHORT).show();
                                   // Intent i = new Intent(CommunityHall.this,ShowDetails.class);
                                    if(submit12!=null) {
                                        submit12.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(CommunityHall.this, ShowDetails.class);

                                                Bundle b = new Bundle();
//Add your data to bundle
                                                b.putString("one", empno.getText().toString());
                                                b.putString("two1", empname.getText().toString());
                                                b.putString("two2", desg.getText().toString());
                                                b.putString("two3", dept.getText().toString());
                                                b.putString("two4", grade.getText().toString());
                                                b.putString("two5", reqno.getText().toString());
                                                b.putString("two6", reqdate.getText().toString());
                                                b.putString("two7", nod.getText().toString());
                                                b.putString("two8", ebookfee.getText().toString());
                                                b.putString("two9", quarno.getText().toString());
                                                b.putString("two10", contno.getText().toString());
                                                b.putString("two11", pincode.getText().toString());
                                                i.putExtras(b);
                                                startActivity(i);
                                                submit12.setOnClickListener(null);

                                            }});



                                }} else {

                                        Toast.makeText(CommunityHall.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }

                }
            });
        }
    }








    private void updateDisplay(TextView dateDisplay, Calendar date) {
        if(dateDisplay!=null) {
            dateDisplay.setText(
                    new StringBuilder()
                            // Month is 0 based so add 1
                            .append(date.get(Calendar.MONTH) + 1).append("-")
                            .append(date.get(Calendar.DAY_OF_MONTH)).append("-")
                            .append(date.get(Calendar.YEAR)).append(" "));
        }
    }

    public void showDateDialog(TextView dateDisplay, Calendar date) {
        activeDateDisplay = dateDisplay;
        activeDate = date;
        showDialog(DATE_DIALOG_ID);

    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            if(activeDate!=null){
            activeDate.set(Calendar.YEAR, year);
            activeDate.set(Calendar.MONTH, monthOfYear);
            activeDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);}
            updateDisplay(activeDateDisplay, activeDate);

                long msDiff = endDate.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();

                long daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff) + 2;

              // nod = (EditText) findViewById(R.id.nod);

                if (nod != null) {
                    nod.setText(String.valueOf(daysDiff));
                }
                long bookfee = daysDiff * 500;
                // ebookfee = (EditText) findViewById(R.id.ebookfee);
                if (ebookfee != null) {
                    ebookfee.setText(String.valueOf(bookfee));
                }


            unregisterDateDisplay();
        }
    };

    private void unregisterDateDisplay() {
        activeDateDisplay = null;
        activeDate = null;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dateSetListener, activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id) {
            case DATE_DIALOG_ID:
                ((DatePickerDialog) dialog).updateDate(activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected (AdapterView< ? > arg0, View arg1, int position, long id){
        //  Toast.makeText(getApplicationContext(), Select_Purpose[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected (AdapterView < ? > arg0){
        // TODO Auto-generated method stub
    }


}