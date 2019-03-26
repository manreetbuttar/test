package com.example.manreet.test;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alertboxlibrary.alertBox.ButtonModel;
import com.example.alertboxlibrary.alertBox.Dailog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView textView;
    ArrayList<ButtonModel> temp=new ArrayList<>();
    String[] buttonName={"submit","cancel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.test);
        for (String buttonname:buttonName){
            ButtonModel buttonModel=new ButtonModel();
            buttonModel.setName(buttonname);
            temp.add(buttonModel);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Dailog.showDialog(MainActivity.this,"title2 wiciwnvn incnoc woicjoiwo onwocnwo vwnonvo oivwnon","message2",temp);

            }
        });
    }
}
