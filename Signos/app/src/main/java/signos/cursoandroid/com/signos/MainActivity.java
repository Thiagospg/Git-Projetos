package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens = {
            "Áries", "Touro", "Gêmeos",
            "Câncer", "Leão", "Virgem",
            "Libra", "Escorpião", "Sagitário",
            "Capricórnio", "Aquario","Peixes"
    };

    private String[] info = {
            "Impulsividade, espontaneidade e ingenuidade", "Realização, teimosia e sensualidade","Inteligência, versatilidade e comunicação",
            "Leal, protetor, simpático, carinhoso, persuasivo, desorganizado, temperamental, inseguro", "Vaidoso, alegre, generoso, amoroso, inflexível, preguiçoso, teimoso, egoísta", "Analítico, gentil, meticuloso, prático, inteligente, tímido, preocupado, crítico",
            "Vaidade, gentileza e idealização", "Intensidade, transformação e mistério", "Originalidade, intuição e inspiração",
            "Responsabilidade, persistência e esforço", "Simpático, original, independente, visionário, humanitário, temperamental, teimoso, imprevisível", "Solidariedade, sensibilidade e intuição"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter( adaptador );

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorClicado = listaItens.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), info[position], Toast.LENGTH_LONG).show();


            }
        });

    }
}
