package com.example.eva1_exa_adivinar_numero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    /*
    Developed by: Team Honeycomb
    17550439, 17550856, 17550921, 16550531
    */

    private RadioGroup rdGroup;
    private RadioButton rdArit, rdAlg;
    private Button btnVerificar;
    private EditText edtResp;
    private TextView txt0;
    int u, o = 2, id, res;
    int [] Arreglo = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdGroup = findViewById(R.id.rdGroup);
        rdArit = findViewById(R.id.rdArit);
        btnVerificar = findViewById(R.id.btnVerificar);
        txt0 = findViewById(R.id.txt0);
        edtResp = findViewById(R.id.edtResp);
        rdGroup.setOnCheckedChangeListener(this);
        btnVerificar.setOnClickListener(this);
    }
    //Este metodo hace un arreglo de numeros random
    public void Random(){
        if (id == 1){
            int a = (int) (Math.random()*9+1);
            int d = (int) (Math.random()*9+1);
            for (int i = 0; i<Arreglo.length; i++ ){
                Arreglo[i] = a;
                a+=d;
            }
        }else {
            int a = (int) (Math.random()*9+1);
            int d = (int) (Math.random()*9+1);
            for (int i = 0; i<Arreglo.length; i++ ){
                Arreglo[i] = a;
                a*=d;
            }
        }
    }

    public void Mostrar(){
        u = (int) (Math.random()*4+0);
        Random();
        txt0.setText("");
        for (int i = 0; i<Arreglo.length; i++ ) {
            if (u==i){
                txt0.setText(txt0.getText()+"--> ? ");
            }else{
                txt0.setText(txt0.getText()+"-->" + Arreglo[i]);
            }
        }
    }

    public void Comprobar(){
        if (Arreglo[u]==res){
            Toast.makeText(getApplicationContext(), "Ganaste", Toast.LENGTH_SHORT).show();
            Mostrar();
        }else{
            Toast.makeText(getApplicationContext(), "Quedan"+ " " + o + " "+"Intentos", Toast.LENGTH_SHORT).show();
            if (o==0){
                Toast.makeText(getApplicationContext(), "Perdiste", Toast.LENGTH_SHORT).show();
                Mostrar();
                o = 2;
                edtResp.setText("");
            }else{
                o--;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rdArit){
            id = 1;
            Mostrar();
            o = 2;
            }else{
            id = 0;
            Mostrar();
            o = 2;
            }
        }

    @Override
    public void onClick(View v) {
        String val;
        val = edtResp.getText().toString();
       if(val.length() == 0){
           Toast.makeText(getApplicationContext(), "Introduce una respuesta", Toast.LENGTH_LONG).show();
       }else{
           res = Integer.parseInt(edtResp.getText().toString());
           Comprobar();
       }
    }
}