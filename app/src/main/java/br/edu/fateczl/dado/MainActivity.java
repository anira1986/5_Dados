/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.dado;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbUmDado;
    private RadioButton rbDoisDados;
    private RadioButton rbTresDados;
    private Spinner spDado;
    private Button btnLancar;
    private TextView tvSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbUmDado = findViewById(R.id.rbUmDado);
        rbUmDado.setChecked(true);
        rbDoisDados = findViewById(R.id.rbDoisDados);
        rbTresDados = findViewById(R.id.rbTresDados);
        spDado = findViewById(R.id.spDado);
        btnLancar = findViewById(R.id.btnLancar);
        tvSaida = findViewById(R.id.tvSaida);

        preencheSpinner();
        btnLancar.setOnClickListener(op -> lancarDados());
    }

    private void lancarDados() {
        StringBuffer buffer = new StringBuffer();
        Integer qtdFaces = (Integer) spDado.getSelectedItem();

        if(rbUmDado.isChecked()){
            buffer.append(faceDado(qtdFaces));
        } else if (rbDoisDados.isChecked()){
            buffer.append(faceDado(qtdFaces)).append(", ");
            buffer.append(faceDado(qtdFaces));
        } else if (rbTresDados.isChecked()){
            buffer.append(faceDado(qtdFaces)).append(", ");
            buffer.append(faceDado(qtdFaces)).append(", ");
            buffer.append(faceDado(qtdFaces));
        }

        tvSaida.setText(buffer.toString());
    }

    private int faceDado(int qtdFaces) {
        Random random = new Random();
        return random.nextInt(qtdFaces) + 1;
    }

    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDado.setAdapter(adapter);
    }
}
