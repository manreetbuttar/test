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

public class Main3Activity extends AppCompatActivity {
    Button bt3,btnt3;
    ArrayList<ButtonModel> temp=new ArrayList<>();
    String[] buttonName={"submit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bt3=findViewById(R.id.bt3);
        btnt3=findViewById(R.id.btnt3);
        for (String buttonname:buttonName){
            ButtonModel buttonModel=new ButtonModel();
            buttonModel.setName(buttonname);
            temp.add(buttonModel);
        }
        bt3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
               Dailog.showDialog(Main3Activity.this,"title3","message3 hcbwijwb jcwbijcij injcwj jcenn hcbwiwbi ijcwbiuiub",temp);
            }
        });



        btnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
