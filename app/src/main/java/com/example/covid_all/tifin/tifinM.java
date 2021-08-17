package com.example.covid_all.tifin;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_all.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class tifinM extends AppCompatActivity {
    RecyclerView recyclerView;
    myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tifin_m);
        getSupportActionBar().setTitle("Tiffin..");
        recyclerView=findViewById(R.id.recyclbapu);
        recyclerView.setLayoutManager(new LinearLayoutManager(tifinM.this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("tifin"), model.class)
                        .build();
        myadapter=new myadapter(options);
        recyclerView.setAdapter(myadapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        myadapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myadapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                proseessearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                proseessearch(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void proseessearch(String s) {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("tifin").orderByChild("name").startAt(s).endAt(s+"\uf88f"), model.class)
                        .build();
        myadapter=new myadapter(options);
        myadapter.startListening();
        recyclerView.setAdapter(myadapter);
    }

}