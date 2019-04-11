package com.example.natanaelgomes.calculodesalario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText edtsalario;
    RadioButton rb40, rb45, rb50;
    RadioGroup rgopcoes;
    Button btcalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtsalario = (EditText) findViewById(R.id.edtsalario);
        rb40 = (RadioButton) findViewById(R.id.rb40);
        rb45 = (RadioButton) findViewById(R.id.rb45);
        rb50 = (RadioButton) findViewById(R.id.rb50);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btcalcular = (Button) findViewById(R.id.btcalcular);


            btcalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double salario = 0;
                    salario = Double.parseDouble(edtsalario.getText().toString());

                    int op = rgopcoes.getCheckedRadioButtonId();

                    if (op == R.id.rb40) {
                        salario = salario + (salario * 0.4);
                    } else if (op == R.id.rb45) {
                        salario = salario + (salario * 0.45);
                    } else {
                        salario = salario + (salario * 0.5);
                    }

                    android.app.AlertDialog.Builder dialogo = new
                    android.app.AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Salario ajusatado:");
                    dialogo.setMessage("Novo salário é: " + salario);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();

                }
            });
        }
}
