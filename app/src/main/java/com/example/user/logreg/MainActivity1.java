package com.example.user.logreg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {
private Button swim,commu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        swim=(Button)findViewById(R.id.swim);
       commu=(Button)findViewById(R.id.commu);
        commu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommunityHall();
            }
        });
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity2();
            }
        });
    }
    private void openCommunityHall() {
        Intent intent=new Intent(this,CommunityHall.class);
        startActivity(intent);
    }


    private void openMainActivity2() {
        Intent intent=new Intent(this,SwimmingPool.class);
        startActivity(intent);
    }

}
