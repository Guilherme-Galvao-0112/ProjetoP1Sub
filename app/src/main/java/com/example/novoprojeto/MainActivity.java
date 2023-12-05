package com.example.novoprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.novoprojeto.model.Livros;
import com.example.novoprojeto.persistence.LivrosDao;
import com.example.novoprojeto.persistence.LivrosImplBD;
import com.example.novoprojeto.ui.activity.AddLivroActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LivrosDao dao;
    private ListView ListaDeLivros;
    private List<Livros>dados;
    private Button addLivro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapeamentoXML();
        consulta();
        vinculaAdapterALista();
        acaoADD();

        Livros livros = new Livros();
        dados=dao.listagem();


    }
    private void mapeamentoXML(){
        setContentView(R.layout.activity_main);
        ListaDeLivros = findViewById(R.id.lv_lista_livros);
        addLivro = findViewById(R.id.fab_botao_add);
    }
    private void vinculaAdapterALista(){
        ListaDeLivros.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados));
    }
    private void consulta(){
        if(dao==null)
            dao = new LivrosImplBD(this);
        dados = dao.listagem();
    }
    private void acaoADD(){
        addLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddLivroActivity.class));
            }
        });

    }
}