package com.example.novoprojeto.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.novoprojeto.R;
import com.example.novoprojeto.model.Livros;
import com.example.novoprojeto.persistence.LivrosDao;

public class AddLivroActivity extends AppCompatActivity {
    private Button botaosalvar;
    private Livros l;
    private EditText titulo;
    private EditText autor;
    private EditText genero;
    private EditText sinopse;
    private LivrosDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acoes();
        mapeamentoXML();
    }
    public void mapeamentoXML(){
        setContentView(R.layout.activity_add_livro);
        titulo = findViewById(R.id.activity_add_livro_titulo);
        autor = findViewById(R.id.activity_add_livro_autor);
        genero = findViewById(R.id.activity_add_livro_genero);
        sinopse = findViewById(R.id.activity_add_livro_sinopse);
        botaosalvar = findViewById(R.id.activity_add_livro_botao_salvar);

    }
    private void acoes() {
        botaosalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (l == null)
                    l = new Livros();
                l.setTitulo(titulo.getText().toString());
                l.setAutor(autor.getText().toString());
                l.setGenero(genero.getText().toString());
                l.setSinopse(sinopse.getText().toString());
                if(l.getId()==null)
                    dao.salvar(l);
                else dao.editar(l);

            }
        });
    }

}