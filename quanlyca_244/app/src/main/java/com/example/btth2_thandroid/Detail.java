package com.example.btth2_thandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.Holder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Detail extends AppCompatActivity {
    TextView tenkhoahoc, tenthuonggoi, dactinh, mausac;
    CircleImageView surl;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tenkhoahoc = findViewById(R.id.tvtenkhoahoc);
        tenthuonggoi = findViewById(R.id.tvtenthuongoi);
        dactinh = findViewById(R.id.tvdactinh);
        mausac = findViewById(R.id.tvmausac);
        surl = findViewById(R.id.anhmota);
        btnback = findViewById(R.id.btnback);
//        Glide.with(getApplicationContext()).load(surl).into(surl);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        surl.setImageResource(getIntent().getIntExtra("anh1", 0));
        tenkhoahoc.setText(getIntent().getStringExtra("science").toString());
        tenthuonggoi.setText(getIntent().getStringExtra("commom").toString());
        dactinh.setText(getIntent().getStringExtra("char").toString());
        mausac.setText(getIntent().getStringExtra("color").toString());
        }
    }
