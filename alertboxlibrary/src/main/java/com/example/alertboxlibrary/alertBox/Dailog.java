package com.example.alertboxlibrary.alertBox;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alertboxlibrary.R;

import java.util.ArrayList;

public class Dailog {

    static LinearLayout linearLayout;
    static int TOPMAR=0;
    static int count=0;
    static int dividerCount=0;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void showDialog(Context context, String title, String message, ArrayList<ButtonModel> tempstore
    ) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_alert);
            initialize(dialog);
            for (int i=0;i<tempstore.size();i++){
                dividerCount=i;
                count=tempstore.size();
                addButton(context, tempstore.get(i).getName(), dialog);

            }
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            final TextView titleid = dialog.findViewById(R.id.title);
            if(title.isEmpty()){
                titleid.setVisibility(View.GONE);
            }else{
                titleid.setVisibility(View.VISIBLE);
            }
            titleid.setText(title);
            final TextView messageid = dialog.findViewById(R.id.message);
            messageid.setText(message);
            TextView okbt = dialog.findViewById(R.id.okbt);
            okbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });




        dialog.show();
    }

    public static void initialize(Dialog dialog) {
        linearLayout = (LinearLayout) dialog.findViewById(R.id.button_Linear_layout);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void addButton(Context context, String buttonName1, final Dialog dialog) {
        TextView btn = new TextView(context);
        if(count==2){

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,0.5f));
            if(dividerCount==1) {
                LinearLayout verticalDivider = new LinearLayout(context);
                verticalDivider.setBackgroundColor(Color.BLACK);
                verticalDivider.setLayoutParams(new LinearLayout.LayoutParams(1, ViewGroup.LayoutParams.MATCH_PARENT));
                ((LinearLayout.LayoutParams) verticalDivider.getLayoutParams()).setMargins(0, 15, 0, 0);
                linearLayout.addView(verticalDivider);
            }
        }else {
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1));
            if(dividerCount!=0) {
                View view = new View(context);
                linearLayout.addView(view);
                view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
                ((LinearLayout.LayoutParams) view.getLayoutParams()).setMargins(0, 15, 0, 0);
                view.setBackgroundColor(Color.BLACK);
            }
        }
        ((LinearLayout.LayoutParams) btn.getLayoutParams()).setMargins(0,10,0,0);
        btn.setText(buttonName1);
        btn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btn.setTextColor(Color.BLUE);
        linearLayout.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
