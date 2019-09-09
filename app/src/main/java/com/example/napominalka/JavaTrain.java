package com.example.napominalka;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class JavaTrain extends AppCompatActivity {
    SeekBar seekBar;
    SeekBar seekBar2;
    SeekBar seekBar3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seekBar = findViewById(R.id.sbHours);
        seekBar2 = findViewById(R.id.sbHours);
        seekBar3 = findViewById(R.id.sbHours);
    }
    private void sss(SeekBar seekBar, final TextView textView){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("ss progress");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
