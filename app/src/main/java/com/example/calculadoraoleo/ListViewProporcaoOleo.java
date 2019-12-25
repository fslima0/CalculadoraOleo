package com.example.calculadoraoleo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewProporcaoOleo extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_proporcao_oleo);

        listView = findViewById(R.id.list);

        String[] valores = new String[]{"40:1 - Motor Barco Usado",
                "30:1 - Motor Barco Novo",
                "25:1 - Moto Serra",
                "20:1 - Moto com Motor 2T",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, valores);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int itemPosicao = i;

                String passar = new String();

                switch (itemPosicao) {
                    case 0: passar = "40:1"; break;
                    case 1: passar = "30:1"; break;
                    case 2: passar = "25:1"; break;
                    case 3: passar = "20:1"; break;
                }

                Intent intent = new Intent();
                intent.putExtra("SEGUNDA_ACTIVITY", passar);
                setResult(ListViewProporcaoOleo.RESULT_OK, intent);
                finish();
            }
        });
    }
}
