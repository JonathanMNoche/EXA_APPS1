package com.example.eva1_exa_control_rotacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ImView;
    TextView txtTitulo, txtSub, txtSub2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImView = findViewById(R.id.ImView);
        ImView.setImageResource(R.drawable.img);
    }
}
