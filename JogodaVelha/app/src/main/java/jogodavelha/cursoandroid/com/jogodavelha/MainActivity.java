package jogodavelha.cursoandroid.com.jogodavelha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnR;

    private String vez="X";
    private int contador=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.botao1);
        btn2 = findViewById(R.id.botao2);
        btn3 = findViewById(R.id.botao3);
        btn4 = findViewById(R.id.botao4);
        btn5 = findViewById(R.id.botao5);
        btn6 = findViewById(R.id.botao6);
        btn7 = findViewById(R.id.botao7);
        btn8 = findViewById(R.id.botao8);
        btn9 = findViewById(R.id.botao9);
        btnR = findViewById(R.id.botaoResetar);

        btnR.setEnabled(false);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn1.setText("X");
                    vez = "O";
                }else{
                    btn1.setText("O");
                    vez = "X";
                }

                if(btn1.getText().equals(btn2.getText())&&btn1.getText().equals(btn3.getText()) && btn1.getText().equals("X")
                        || (btn1.getText().equals(btn5.getText())&&btn1.getText().equals(btn9.getText()) && btn1.getText().equals("X")
                        || (btn1.getText().equals(btn4.getText())&&btn1.getText().equals(btn7.getText()) && btn1.getText().equals("X"))
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn1.getText().equals(btn2.getText())&&btn1.getText().equals(btn3.getText()) && btn1.getText().equals("O")
                        || (btn1.getText().equals(btn5.getText())&&btn1.getText().equals(btn9.getText()) && btn1.getText().equals("O")
                        || (btn1.getText().equals(btn4.getText())&&btn1.getText().equals(btn7.getText()) && btn1.getText().equals("O"))

                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }
                btn1.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn2.setText("X");
                    vez = "O";
                }else{
                    btn2.setText("O");
                    vez = "X";
                }

                if(btn2.getText().equals(btn1.getText())&&btn2.getText().equals(btn3.getText()) && btn2.getText().equals("X")
                        || (btn2.getText().equals(btn5.getText())&&btn2.getText().equals(btn8.getText()) && btn2.getText().equals("X")
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn2.getText().equals(btn1.getText())&&btn2.getText().equals(btn3.getText()) && btn2.getText().equals("O")
                        || (btn2.getText().equals(btn5.getText())&&btn2.getText().equals(btn8.getText()) && btn2.getText().equals("O")
                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }
                btn2.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn3.setText("X");
                    vez = "O";
                }else{
                    btn3.setText("O");
                    vez = "X";
                }

                if(btn3.getText().equals(btn2.getText())&&btn3.getText().equals(btn1.getText()) && btn3.getText().equals("X")
                        || (btn3.getText().equals(btn5.getText())&&btn3.getText().equals(btn7.getText()) && btn3.getText().equals("X")
                        || (btn3.getText().equals(btn6.getText())&&btn3.getText().equals(btn9.getText()) && btn3.getText().equals("X"))
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn3.getText().equals(btn2.getText())&&btn3.getText().equals(btn1.getText()) && btn3.getText().equals("O")
                        || (btn3.getText().equals(btn5.getText())&&btn3.getText().equals(btn7.getText()) && btn3.getText().equals("O")
                        || (btn3.getText().equals(btn6.getText())&&btn3.getText().equals(btn9.getText()) && btn3.getText().equals("O"))

                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn3.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn4.setText("X");
                    vez = "O";
                }else{
                    btn4.setText("O");
                    vez = "X";
                }

                if(btn4.getText().equals(btn5.getText())&&btn4.getText().equals(btn6.getText()) && btn4.getText().equals("X")
                        || (btn4.getText().equals(btn1.getText())&&btn4.getText().equals(btn7.getText()) && btn4.getText().equals("X")
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn4.getText().equals(btn5.getText())&&btn4.getText().equals(btn6.getText()) && btn4.getText().equals("O")
                        || (btn4.getText().equals(btn1.getText())&&btn4.getText().equals(btn7.getText()) && btn4.getText().equals("O")
                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;

                }

                btn4.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn5.setText("X");
                    vez = "O";
                }else{
                    btn5.setText("O");
                    vez = "X";
                }

                if(btn5.getText().equals(btn4.getText())&&btn5.getText().equals(btn6.getText()) && btn5.getText().equals("X")
                        || (btn5.getText().equals(btn2.getText())&&btn5.getText().equals(btn8.getText()) && btn5.getText().equals("X")
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn5.getText().equals(btn4.getText())&&btn5.getText().equals(btn6.getText()) && btn5.getText().equals("O")
                        || (btn5.getText().equals(btn2.getText())&&btn5.getText().equals(btn8.getText()) && btn5.getText().equals("O")
                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn5.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn6.setText("X");
                    vez = "O";
                }else{
                    btn6.setText("O");
                    vez = "X";
                }

                if(btn6.getText().equals(btn4.getText())&&btn6.getText().equals(btn5.getText()) && btn6.getText().equals("X")
                        || (btn6.getText().equals(btn3.getText())&&btn6.getText().equals(btn9.getText()) && btn6.getText().equals("X")
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn6.getText().equals(btn4.getText())&&btn6.getText().equals(btn5.getText()) && btn6.getText().equals("O")
                        || (btn6.getText().equals(btn3.getText())&&btn6.getText().equals(btn9.getText()) && btn6.getText().equals("O")
                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn6.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn7.setText("X");
                    vez = "O";
                }else{
                    btn7.setText("O");
                    vez = "X";
                }

                if(btn7.getText().equals(btn1.getText())&&btn7.getText().equals(btn4.getText()) && btn7.getText().equals("X")
                        || (btn7.getText().equals(btn5.getText())&&btn7.getText().equals(btn3.getText()) && btn7.getText().equals("X")
                        || (btn7.getText().equals(btn8.getText())&&btn7.getText().equals(btn9.getText()) && btn7.getText().equals("X"))
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn7.getText().equals(btn1.getText())&&btn7.getText().equals(btn4.getText()) && btn7.getText().equals("O")
                        || (btn7.getText().equals(btn5.getText())&&btn7.getText().equals(btn3.getText()) && btn7.getText().equals("O")
                        || (btn7.getText().equals(btn8.getText())&&btn7.getText().equals(btn9.getText()) && btn7.getText().equals("O"))

                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn7.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn8.setText("X");
                    vez = "O";
                }else{
                    btn8.setText("O");
                    vez = "X";
                }

                if(btn8.getText().equals(btn7.getText())&&btn8.getText().equals(btn9.getText()) && btn8.getText().equals("X")
                        || (btn8.getText().equals(btn5.getText())&&btn8.getText().equals(btn2.getText()) && btn8.getText().equals("X")
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn8.getText().equals(btn7.getText())&&btn8.getText().equals(btn9.getText()) && btn8.getText().equals("O")
                        || (btn8.getText().equals(btn5.getText())&&btn8.getText().equals(btn2.getText()) && btn8.getText().equals("O")
                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn8.setEnabled(false);
                contador++;
                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vez.equals("X")&&vez != null) {
                    btn9.setText("X");
                    vez = "O";
                }else{
                    btn9.setText("O");
                    vez = "X";
                }

                if(btn9.getText().equals(btn3.getText())&&btn9.getText().equals(btn6.getText()) && btn9.getText().equals("X")
                        || (btn9.getText().equals(btn5.getText())&&btn9.getText().equals(btn1.getText()) && btn9.getText().equals("X")
                        || (btn9.getText().equals(btn8.getText())&&btn9.getText().equals(btn7.getText()) && btn9.getText().equals("X"))
                )){
                    Toast.makeText(getApplicationContext(), "X venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                } else if(btn9.getText().equals(btn3.getText())&&btn9.getText().equals(btn6.getText()) && btn9.getText().equals("O")
                        || (btn9.getText().equals(btn5.getText())&&btn9.getText().equals(btn1.getText()) && btn9.getText().equals("O")
                        || (btn9.getText().equals(btn8.getText())&&btn9.getText().equals(btn7.getText()) && btn9.getText().equals("O"))

                )){
                    Toast.makeText(getApplicationContext(), "O venceu", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                    contador--;
                }

                btn9.setEnabled(false);
                contador++;

                if (contador == 9){
                    Toast.makeText(getApplicationContext(), "Deu velha!", Toast.LENGTH_SHORT).show();
                    btnR.setEnabled(true);
                    btnR.setTextColor(Color.parseColor("#ce584c"));
                }
            }
        });



        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
                btnR.setTextColor(Color.parseColor("#bdbdbd"));
            }
        });

    }
    private void restart(){
        btn1.setEnabled(true);
        btn1.setText(null);
        btn2.setEnabled(true);
        btn2.setText(null);
        btn3.setEnabled(true);
        btn3.setText(null);
        btn4.setEnabled(true);
        btn4.setText(null);
        btn5.setEnabled(true);
        btn5.setText(null);
        btn6.setEnabled(true);
        btn6.setText(null);
        btn7.setEnabled(true);
        btn7.setText(null);
        btn8.setEnabled(true);
        btn8.setText(null);
        btn9.setEnabled(true);
        btn9.setText(null);
        btnR.setEnabled(false);
        contador=0;

    }
}
