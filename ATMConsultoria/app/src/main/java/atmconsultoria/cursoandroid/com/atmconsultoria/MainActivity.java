package atmconsultoria.cursoandroid.com.atmconsultoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    
    private ImageView imgEmpresa;
    private ImageView imgServicos;
    private  ImageView imgClientes;
    private ImageView imgContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgEmpresa = findViewById(R.id.imgEmpresaId);
        imgClientes = findViewById(R.id.imgClientesId);
        imgContato = findViewById(R.id.imgContatoId);
        imgServicos = findViewById(R.id.imgServicosId);



        imgEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmpresaActivity.class));
            }
        });

        imgServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicosActivity.class));
            }
        });

        imgContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });

        imgClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientesActivity.class));
            }
        });
    }
}
