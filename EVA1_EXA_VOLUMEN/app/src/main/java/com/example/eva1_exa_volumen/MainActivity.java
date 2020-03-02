package com.example.eva1_exa_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtRadio;
    TextView txtSel, textView5, txt0, txt1;
    Button btnCalcular;
    SeekBar barAng;
    private double Radio, Ang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtRadio = findViewById(R.id.edtTextRadio);
        txtSel = findViewById(R.id.textSel);
        btnCalcular = findViewById(R.id.btnCalcular);
        barAng = findViewById(R.id.barAng);
        barAng.setMax(360);
        setBar();


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = 0;
                Radio = Double.parseDouble(edtRadio.getText().toString());
                Radio = (double)Math.pow(Radio, 3);
                res = ((0.666)*(Radio*Ang));
                DecimalFormat var = new DecimalFormat("#.###");
                Toast.makeText(getApplicationContext(), var.format(res), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setBar() {
        txtSel.setText(" " + barAng.getProgress());
        barAng.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSel.setText(" " + progress);
                Ang = progress;
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
