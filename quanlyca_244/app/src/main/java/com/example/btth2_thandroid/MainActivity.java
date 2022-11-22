package com.example.btth2_thandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CaAdapter caAdapter;

    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        FirebaseRecyclerOptions<Ca> options =
                new FirebaseRecyclerOptions.Builder<Ca>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ca"), Ca.class)
                        .build();

        caAdapter = new CaAdapter(options);
        recyclerView.setAdapter(caAdapter);



        floatingActionButton =(FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(i);
          }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        caAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        caAdapter.stopListening();
    }
}