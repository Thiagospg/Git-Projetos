package caraoucoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    private ImageView botaoVoltar;
    private ImageView imgMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        botaoVoltar = findViewById(R.id.botaoVoltarId);
        imgMoeda = findViewById(R.id.imagemMoedaId);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            String opcaoEscolhida = extra.getString("opcao");

            if(opcaoEscolhida.equals("cara")){
                imgMoeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            }else{
                imgMoeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
            }
        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });


    }
}
