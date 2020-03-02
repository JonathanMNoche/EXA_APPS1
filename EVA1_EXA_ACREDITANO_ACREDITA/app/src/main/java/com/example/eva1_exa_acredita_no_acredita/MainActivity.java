package com.example.eva1_exa_acredita_no_acredita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Se crean los dos seekbar
    SeekBar sB, sB2;
    //Estos son los text view's, el que muestra el resultado, el que muestra la calificación
    // requerida y el que muestra la calificación qué sacó la persona
    TextView tVRes, tVCali, tVAcr;

    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos las variables con los componentes del layout
        sB = findViewById(R.id.sB1);
        sB2 = findViewById(R.id.sB2);
        tVRes = findViewById(R.id.tVRes);
        tVCali = findViewById(R.id.tVCali);
        tVAcr = findViewById(R.id.tVAcr);

        //Agregamos a los seekbar un progreso de cero
        sB.setProgress(0);
        sB2.setProgress(0);
        // Agregamos al seekbar un valor final o máximo
        sB.setMax(100);
        sB2.setMax(100);

        //Agregamos los listeners a cada uno de los seekbar's

        //Seek bar 1
        sB.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //Un escuchador para cada vez que se mueve el progreso
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //Con esto, al momento de mover la barra de progreso, se va a poner cuánto del progreso lleva,
                        // en el text view de calificación necesaria para acreditación
                        tVAcr.setText("" + sB.getProgress());

                        //Este if es para comparar un seek bar con el otro. El primero debe de tener menor número que el segundo para poder acreditar
                        if(sB.getProgress() > sB2.getProgress()){
                            tVRes.setText("No acredita");
                        }
                        else{
                            tVRes.setText("Acredita");
                        }
                    }

                    //Estos son los métodos que pide el implementar
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        //Seek bar dos

        sB2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //Un escuchador para cada vez que se mueve el progreso
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //Con esto, al momento de mover la barra de progreso, se va a poner cuánto del progreso lleva,
                        // en el text view de calificación necesaria para acreditación
                        tVCali.setText("" + sB2.getProgress());

                        //Este if es para comparar un seek bar con el otro. El primero debe de tener menor número que el segundo para poder acreditar
                        if(sB.getProgress() > sB2.getProgress()){
                            tVRes.setText("No acredita");
                        }
                        else{
                            tVRes.setText("Acredita");
                        }
                    }

                    //Estos son los métodos que pide el implementar
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

    }
}