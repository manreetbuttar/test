package com.example.alertboxlibrary.alertBox;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alertboxlibrary.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button bt2,btnt2,back;
    ArrayList<ButtonModel> temp=new ArrayList<>();
    String[] buttonName={"submit","cancel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt2=findViewById(R.id.bt2);
        btnt2=findViewById(R.id.btnt2);
        back=findViewById(R.id.back);
        for (String buttonname:buttonName){
            ButtonModel buttonModel=new ButtonModel();
            buttonModel.setName(buttonname);
            temp.add(buttonModel);
        }
        bt2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Dailog.showDialog(Main2Activity.this,"title2 wiciwnvn incnoc woicjoiwo onwocnwo vwnonvo oivwnon","message2",temp);
            }
        });

        btnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
