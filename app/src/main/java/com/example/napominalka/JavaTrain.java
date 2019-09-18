package com.example.napominalka;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.example.napominalka.db.Event;

import java.util.List;

public class JavaTrain extends AppCompatActivity {
    EventViewModel eventViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.getAllEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                //update RecyclerView
            }
        });
    }
}
