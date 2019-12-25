package com.example.calculadoraoleo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button consulta, calcular_oleo;
    private static final int SEGUNDA_ACTIVITY = 1;
    EditText quantidade, proporcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consulta = findViewById(R.id.botao_consulta);
        quantidade = findViewById(R.id.quantidade);
        proporcao = findViewById(R.id.proporcao);

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListViewProporcaoOleo.class);
                startActivityForResult(intent, SEGUNDA_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SEGUNDA_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String s = data.getStringExtra("SEGUNDA_ACTIVITY");
                proporcao.setText(s);
            }
        }
    }

    public void calcular_oleo(View view) {
        String p = proporcao.getText().toString();

        if (quantidade.getText() != null && proporcao.getText() != null) {
            String partes[] = p.split(":");

            double qtd = Double.parseDouble(quantidade.getText().toString());
            double n1 = Double.parseDouble(partes[0]);
            double n2 = Double.parseDouble(partes[1]);
            double resultado = qtd / (n1/n2);

            Toast.makeText(getApplicationContext(), "Resultado: " + resultado, Toast.LENGTH_SHORT).show();
        }
    }
}
