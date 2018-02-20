package alcoolougasolina.cursoandroid.com.alcoolougasolina;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.edtPrecoAlcoolId);
        precoGasolina = findViewById(R.id.edtPrecoGasolinaId);
        botaoVerificar = findViewById(R.id.btnVerificarId);
        textoResultado = findViewById(R.id.txtResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(precoAlcool.getText().toString().isEmpty()|| precoGasolina.getText().toString().isEmpty() || precoAlcool.getText().toString().startsWith(".") || precoGasolina.getText().toString().startsWith(".")){
                    Toast.makeText(getApplicationContext(),"Digite os valores corretamente.",Toast.LENGTH_SHORT).show();
                }else {
                    double valorAlcool = Double.parseDouble(precoAlcool.getText().toString());
                    double valorGasolina = Double.parseDouble(precoGasolina.getText().toString());


                    if (valorAlcool / valorGasolina <= 0.7) {
                        textoResultado.setText("Vale mais a pena abastecer com Álcool.");
                    } else {
                        textoResultado.setText("Vale mais a pena abastecer com Gasolina.");
                    }
                }
            }
        });



    }
}
