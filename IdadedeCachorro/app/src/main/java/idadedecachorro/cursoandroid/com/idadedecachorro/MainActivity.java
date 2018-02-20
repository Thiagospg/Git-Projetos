package idadedecachorro.cursoandroid.com.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textoIdade;
    private Button botaoCalcular;
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoIdade = findViewById(R.id.edtIdade);
        botaoCalcular = findViewById(R.id.btnDescobrir);
        textoResultado = findViewById(R.id.txtResultado);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperar o que foi digitado

                String textoDigitado = textoIdade.getText().toString();

                if(textoDigitado.isEmpty()){
                    textoResultado.setText("Digite a idade do cachorro do cahorro");
                }else{
                    int textoDigitadoInt = Integer.parseInt(textoDigitado);
                    int resultado = textoDigitadoInt*7;

                    textoResultado.setText("O cachorro tem aproximadamente: "+ resultado +" anos humanos");
                }


            }
        });





    }
}
