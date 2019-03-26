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

public class MainActivity extends AppCompatActivity {
    Button bt1,btnt;
    ArrayList<ButtonModel> temp=new ArrayList<>();
    String[] buttonName={"submit","cancel","save"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (String buttonname:buttonName){
            ButtonModel buttonModel=new ButtonModel();
            buttonModel.setName(buttonname);
            temp.add(buttonModel);
        }
        bt1=findViewById(R.id.bt1);
        btnt=findViewById(R.id.btnt);

        bt1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {

                Dailog.showDialog(MainActivity.this,"title","message1",temp);
            }
        });


        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }

}
