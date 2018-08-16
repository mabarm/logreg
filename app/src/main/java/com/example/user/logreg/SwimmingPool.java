package com.example.user.logreg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SwimmingPool extends AppCompatActivity {

    private EditText empname, empno, desg, grade, section, remarks, dept, contno, quarno, memname, memdob, memrel, swimlev;
    private Button submit,submit12;
    private DatabaseReference mDatabaseMultipleVals;
    private FirebaseUser user;

    //private String muserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming_pool);

            empname = (EditText) findViewById(R.id.empname);
        empno = (EditText) findViewById(R.id.empno);
        desg = (EditText) findViewById(R.id.empdesg);
        grade = (EditText) findViewById(R.id.grade);
        section = (EditText) findViewById(R.id.section);
        remarks = (EditText) findViewById(R.id.remarks);
        dept = (EditText) findViewById(R.id.dept);
        contno = (EditText) findViewById(R.id.contno);
        quarno = (EditText) findViewById(R.id.quarno);
        memname = (EditText) findViewById(R.id.memname);
        memdob = (EditText) findViewById(R.id.memdob);
        memrel = (EditText) findViewById(R.id.memrel);
        swimlev = (EditText) findViewById(R.id.swimlev);
        submit = (Button) findViewById(R.id.submit);
        submit12 = (Button) findViewById(R.id.submit12);

        user = FirebaseAuth.getInstance().getCurrentUser();




              submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user !=null)

                    mDatabaseMultipleVals = FirebaseDatabase.getInstance().getReferenceFromUrl("https://logreg-8fb1c.firebaseio.com/Sarovar Acquatic Club");

                String eno=empno.getText().toString().trim();
                String ename=empname.getText().toString().trim();
                String edesg=desg.getText().toString().trim();
                String edept=dept.getText().toString().trim();
                String eremarks=remarks.getText().toString().trim();
                String esection=section.getText().toString().trim();
                String econtno=contno.getText().toString().trim();
                String equarno=quarno.getText().toString().trim();
                String egrade=grade.getText().toString().trim();
                String ememname=memname.getText().toString().trim();
                String ememdob=memdob.getText().toString().trim();
                String ememrel=memrel.getText().toString().trim();
                String eswimlev=swimlev.getText().toString().trim();


                if(TextUtils.isEmpty(eno)){Toast.makeText(SwimmingPool.this,"Please enter employee no",Toast.LENGTH_SHORT).show();}

                else if(TextUtils.isEmpty(ename)){Toast.makeText(SwimmingPool.this,"Please enter employee name",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(edesg)){Toast.makeText(SwimmingPool.this,"Please enter designation ",Toast.LENGTH_SHORT).show();}

                    else  if(TextUtils.isEmpty(edept)){Toast.makeText(SwimmingPool.this,"Please enter department",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(eremarks)){Toast.makeText(SwimmingPool.this,"Please enter remarks",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(esection)){Toast.makeText(SwimmingPool.this,"Please enter section",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(econtno)){Toast.makeText(SwimmingPool.this,"Please enter contact no",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(equarno)){Toast.makeText(SwimmingPool.this,"Please enter quarter no",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(egrade)){Toast.makeText(SwimmingPool.this,"Please enter grade",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(ememname)){Toast.makeText(SwimmingPool.this,"Please enter member name",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(ememdob)){Toast.makeText(SwimmingPool.this,"Please enter member date of birth",Toast.LENGTH_SHORT).show();}

                    else  if(TextUtils.isEmpty(ememrel)){Toast.makeText(SwimmingPool.this,"Please enter member relation",Toast.LENGTH_SHORT).show();}

                    else if(TextUtils.isEmpty(eswimlev)){Toast.makeText(SwimmingPool.this,"Please enter swimming level",Toast.LENGTH_SHORT).show();}

                // We can safely insert data into our firebase database
               else{ HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("Employee No",empno.getText().toString());
                hashMap.put("Employee Name",empname.getText().toString());
                hashMap.put("Designation",desg.getText().toString());
                hashMap.put("Department",dept.getText().toString());
                hashMap.put("Grade",  grade.getText().toString());
                hashMap.put("Section",section.getText().toString());
                hashMap.put("Contact No",contno.getText().toString());
                hashMap.put("Quarter No",quarno.getText().toString());
                hashMap.put("Member name",memname.getText().toString());
                hashMap.put("Member DOB",memdob.getText().toString());
                hashMap.put("Member Relation",memrel.getText().toString());
                hashMap.put("Swimming Level",swimlev.getText().toString());




                mDatabaseMultipleVals.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SwimmingPool.this, "User data successfully saved.", Toast.LENGTH_SHORT).show();
                            if(submit12!=null) {
                                submit12.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(SwimmingPool.this, ShowDetails.class);

                                        Bundle b = new Bundle();
//Add your data to bundle
                                        b.putString("one", empno.getText().toString());
                                        b.putString("two1", empname.getText().toString());
                                        b.putString("two2", desg.getText().toString());
                                        b.putString("two3", grade.getText().toString());
                                        b.putString("two4", section.getText().toString());
                                        b.putString("two5", remarks.getText().toString());
                                        b.putString("two6", dept.getText().toString());
                                        b.putString("two7", contno.getText().toString());
                                        b.putString("two8", quarno.getText().toString());
                                        b.putString("two9", memname.getText().toString());
                                        b.putString("two10", memdob.getText().toString());
                                        b.putString("two11", memrel.getText().toString());
                                        b.putString("two12", swimlev.getText().toString());

                                        i.putExtras(b);
                                        startActivity(i);
                                        submit12.setOnClickListener(null);

                                    }});



                            } else {
                            Toast.makeText(SwimmingPool.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();}

                            }
                        }
                    });
                }

                }
            });
              }
    }