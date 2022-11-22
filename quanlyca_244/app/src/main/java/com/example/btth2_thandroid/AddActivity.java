package com.example.btth2_thandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText tenkhoahoc,tenthuonggoi,dactinh,surl, mausac;
    Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tenkhoahoc = findViewById(R.id.txttenkhoahoc);
        tenthuonggoi = findViewById(R.id.txttenthuonggoi);
        dactinh = findViewById(R.id.txtdactinh);
        mausac = findViewById(R.id.txtmausac);
        surl = findViewById(R.id.txtImageUrl);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void insertData(){
        Map<String,Object> map = new HashMap<>();
        map.put("sciencename",tenkhoahoc.getText().toString());
        map.put("commonname",tenthuonggoi.getText().toString());
        map.put("characteristic",dactinh.getText().toString());
        map.put("color",mausac.getText().toString());
        map.put("surl",surl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Ca").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this,"Thêm dữ liệu thành công!",Toast.LENGTH_SHORT).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this,"Thêm dữ liệu thất bại!",Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll(){
        tenkhoahoc.setText("");
        tenthuonggoi.setText("");
        dactinh.setText("");
        mausac.setText("");
        surl.setText("");
    }
}