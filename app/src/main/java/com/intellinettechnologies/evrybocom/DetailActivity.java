package com.intellinettechnologies.evrybocom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.intellinettechnologies.evrybocom.application.myapplication;
import com.intellinettechnologies.evrybocom.model.Data;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
 TextView mType;
 ImageView mImageView;
 String id;
 int myI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            id = extras.getString("ID");
        }
    InitilizeVariableAndPopulate();

    }

    private void InitilizeVariableAndPopulate() {
        ArrayList<Data> data = myapplication.getExamples();

        for(int i = 0 ; i<data.size();i++)
        {
            if(data.get(i).getId().equals(id))
            {
                myI = i;
            }
        }


        mType = findViewById(R.id.dType);
        mType.setText(data.get(myI).getType());

        mType = findViewById(R.id.dVendor);
        mType.setText(data.get(myI).getVendor());

        mType = findViewById(R.id.dCode);
        mType.setText(data.get(myI).getCode());

        mType = findViewById(R.id.dAvailable);
        mType.setText(data.get(myI).getAvailable());

        mType = findViewById(R.id.dAvailable1);
        mType.setText(data.get(myI).getAvailable1());

        mType = findViewById(R.id.dDate);
        mType.setText(data.get(myI).getDate());

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        mImageView = findViewById(R.id.detailImage);

        Glide.with(getApplicationContext())
                .load(myapplication.getMyImages().get(myI))
                .apply(options)
                .into(mImageView);

//        mImageView.setImageDrawable(myapplication.getMyImages().get(myI));












    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
