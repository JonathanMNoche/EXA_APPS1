package com.example.eva1_exa_tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    Developed by: Team Honeycomb
    17550439, 17550856, 07550921, 16550531
    */

    Button btn1, btn2, btn3, btn4, btn5, btn6,btn7,btn8,btn9,btnReiniciar;
    TextView txtGanar;
    String equipoGana;
    int cont=0;

    public void compruebaGanar() {   //Comprueba si ya gano alguien o existe un empate al llenar el tablero
            if (comb1() || comb2() || comb3() || comb4() ||
                    comb5() || comb6() || comb7() || comb8()) {
                mensaje("Ha ganado: " + equipoGana);
                txtGanar.setText("Gana: " + equipoGana);
            } else if ((cont>=9) && comprCampos() && (!comb1() || !comb2() || !comb3() || !comb4() ||
                    !comb5() || !comb6() || !comb7() || !comb8())) {
                mensaje("Empate");
                txtGanar.setText("Empate");
            }
        }


    public void mensaje (String equipo) {  //Manda el Alertview diciendo si gana alguien o hay empate
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage(equipo);
        mensaje.setCancelable(true);

        mensaje.setPositiveButton(  //Opcion "Reiniciar" para reiniciar el juego
                "Reiniciar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reiniciar();
                     //   dialog.cancel();
                    }
                });
        mensaje.setNegativeButton(  //Opcion "Cancelar" Para no hacer nada
                "Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = mensaje.create();
        alert11.show();
    }

    public boolean comprCampos () {  //Comprueba que los campos ya tengan una X o una O
        if(btn1.getText() != "-" && btn2.getText() != "-" && btn3.getText() != "-"
                    && btn4.getText() != "-" && btn5.getText() != "-" && btn6.getText() != "-"
                    && btn7.getText() != "-" && btn8.getText() != "-" && btn9.getText() != "-") {
            return true;
        } return false;
    }

    public boolean comb1() {   //Comprueba Ganando diagonal izquierda a derecha
        if((btn1.getText()=="X" && btn5.getText()=="X" && btn9.getText()=="X") ||
                (btn1.getText()=="O" && btn5.getText()=="O" && btn9.getText()=="O")){
            equipoGana=((String)btn1.getText());
            return true; }
        return false;
    }

    public boolean comb2() {    //Comprueba Ganando diagonal derecha a Izquierda
        if((btn3.getText()=="X" && btn5.getText()=="X" && btn7.getText()=="X") ||
                (btn3.getText()=="O" && btn5.getText()=="O" && btn7.getText()=="O")){
            equipoGana=((String)btn3.getText());
            return true; }
        return false;
    }

    public boolean comb3() {    //Comprueba ganando Horizontalmente, en la linea superior
        if((btn1.getText()=="X" && btn2.getText()=="X" && btn3.getText()=="X") ||
                (btn1.getText()=="O" && btn2.getText()=="O" && btn3.getText()=="O")){
            equipoGana=((String)btn1.getText());
            return true; }
        return false;
    }

    public boolean comb4() {    //Comprueba ganando Horizontalmente, en la linea central
        if((btn4.getText()=="X" && btn5.getText()=="X" && btn6.getText()=="X") ||
                (btn4.getText()=="O" && btn5.getText()=="O" && btn6.getText()=="O")){
            equipoGana=((String)btn4.getText());
            return true; }
        return false;
    }

    public boolean comb5() {    //Comprueba ganando Horizontalmente, en la linea inferior
        if((btn7.getText()=="X" && btn8.getText()=="X" && btn9.getText()=="X") ||
                (btn7.getText()=="O" && btn8.getText()=="O" && btn9.getText()=="O")){
            equipoGana=((String)btn7.getText());
            return true; }
        return false;
    }

    public boolean comb6() {    //Comprueba ganando verticalmente, en la linea izquierda
        if((btn1.getText()=="X" && btn4.getText()=="X" && btn7.getText()=="X") ||
                (btn1.getText()=="O" && btn4.getText()=="O" && btn7.getText()=="O")){
            equipoGana=((String)btn1.getText());
            return true; }
        return false;
    }

    public boolean comb7() {    //Comprueba ganando verticalmente, en la linea central
        if((btn2.getText()=="X" && btn5.getText()=="X" && btn8.getText()=="X") ||
                (btn2.getText()=="O" && btn5.getText()=="O" && btn8.getText()=="O")){
            equipoGana=((String)btn2.getText());
            return true; }
        return false;
    }

    public boolean comb8() {    //Comprueba ganando verticalmente, en la linea derecha
        if((btn3.getText()=="X" && btn6.getText()=="X" && btn9.getText()=="X") ||
                (btn3.getText()=="O" && btn6.getText()=="O" && btn9.getText()=="O")){
            equipoGana=((String)btn3.getText());
            return true; }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos vistas de cada widget

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnReiniciar=findViewById(R.id.btnReiniciar);
        txtGanar=findViewById(R.id.txtGanar);




        btn1.setOnClickListener(new View.OnClickListener() {  //Detectamos cuando damos click en un boton
            @Override
            public void onClick(View v) {
                if(cont%2==0) {         //Dependiendo del valor del contador, si es par, pone "O" en el boton
                    btn1.setText("O");
                    btn1.setClickable(false);   //Deshabilita el boton
                } else {
                    btn1.setText("X");  //Dependiendo del valor del contador, si es par, pone "X" en el boton
                    btn1.setClickable(false);
                }
                cont++;     //suma el valor del contador para Alternar turnos, en cada boton se aplica
                compruebaGanar();  //Llama a la funcion que comprueba si alguien gana, o si hay un empate al terminar partida
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {  //Funciona Igual que el boton anterior, del btn1 al btn9
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn2.setText("O");
                    btn2.setClickable(false);
                } else {
                    btn2.setText("X");
                    btn2.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn3.setText("O");
                    btn3.setClickable(false);
                } else {
                    btn3.setText("X");
                    btn3.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn4.setText("O");
                    btn4.setClickable(false);
                } else {
                    btn4.setText("X");
                    btn4.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn5.setText("O");
                    btn5.setClickable(false);
                } else {
                    btn5.setText("X");
                    btn5.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn6.setText("O");
                    btn6.setClickable(false);
                } else {
                    btn6.setText("X");
                    btn6.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn7.setText("O");
                    btn7.setClickable(false);
                } else {
                    btn7.setText("X");
                    btn7.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn8.setText("O");
                    btn8.setClickable(false);
                } else {
                    btn8.setText("X");
                    btn8.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cont%2==0) {
                    btn9.setText("O");
                    btn9.setClickable(false);
                } else {
                    btn9.setText("X");
                    btn9.setClickable(false);
                }
                cont++;
                compruebaGanar();
            }
        });

        //El boton reiniciar.... Reinicia, vaya....
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            reiniciar();

            }
        });


    }

    public void btnOn() {      //Habilita los botones al reinicar la partida
        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);
    }

    public void reiniciar () {  //Reinicia el juego, coloca los guiones en los botones,
        btn1.setText("-");          //Habilita los botones, y el contador lo reinicia a cero
        btn2.setText("-");
        btn3.setText("-");
        btn4.setText("-");
        btn5.setText("-");
        btn6.setText("-");
        btn7.setText("-");
        btn8.setText("-");
        btn9.setText("-");
        txtGanar.setText(" ");
        btnOn();
        cont=0;
    }
}
