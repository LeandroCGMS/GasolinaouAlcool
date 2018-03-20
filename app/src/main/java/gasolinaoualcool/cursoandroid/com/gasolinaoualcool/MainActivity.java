package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText precoAlcool;
    private EditText precoGas;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcoolId);
        precoGas = findViewById(R.id.precoGasId);
        botaoVerificar = findViewById(R.id.botaoVerificarId);
        textoResultado = findViewById(R.id.textoResultadoId);



        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    menu();
                } catch(Exception e){ // adição Toast
                    Toast.makeText(getApplicationContext(),"Erro, verifique se um dos campos está vazio.",Toast.LENGTH_SHORT).show();
                    textoResultado.setText("Erro, verifique se um dos campos está vazio.");
                }



            }

            public void menu(){
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGas = precoGas.getText().toString();

                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGas = Double.parseDouble(textoPrecoGas);

                double resultado = valorAlcool / valorGas;
                if(resultado >= 0.7){
                    textoResultado.setText("É melhor utilizar gasolina.");
                } else {
                    textoResultado.setText("É melhor utilizar álcool.");
                }
            }
        });
    }
}
