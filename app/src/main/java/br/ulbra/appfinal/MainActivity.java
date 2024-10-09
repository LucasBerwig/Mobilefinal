package br.ulbra.appfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtPassos;
    RadioGroup rgDistancia;
    CheckBox chkCorrida;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPassos = findViewById(R.id.edtPassos);
        rgDistancia = findViewById(R.id.rgDistancia);
        chkCorrida = findViewById(R.id.chkCorrida);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passosStr = edtPassos.getText().toString();

                if (passosStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira a quantidade de passos", Toast.LENGTH_SHORT).show();
                    return;
                }

                int numPassos = Integer.parseInt(passosStr);


                double tamanhoPasso = 0;
                int selectedRadioButtonId = rgDistancia.getCheckedRadioButtonId();

                if (selectedRadioButtonId == R.id.btn1) {
                    tamanhoPasso = 0.5;
                } else if (selectedRadioButtonId == R.id.btn2) {
                    tamanhoPasso = 0.7;
                } else if (selectedRadioButtonId == R.id.btn3) {
                    tamanhoPasso = 1.0;
                }

                double distancia = numPassos * tamanhoPasso;

                if (chkCorrida.isChecked()) {
                    distancia *= 1.1;
                }
                txtResultado.setText("Distância percorrida: " + String.format("%.2f", distancia) + " metros");
            }
        });
    }
}