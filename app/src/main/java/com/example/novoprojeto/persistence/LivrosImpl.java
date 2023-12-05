package com.example.novoprojeto.persistence;

import com.example.novoprojeto.model.Livros;

import java.util.ArrayList;
import java.util.List;

public class LivrosImpl implements LivrosDao{
    private List lista;
    public LivrosImpl(){
        lista = new ArrayList();
    }
    @Override
    public void salvar(Livros l) {
        lista.add(l);
    }

    @Override
    public void editar(Livros l) {
        if(lista.contains(l)){
            lista.add(lista.indexOf(l),l);
        }
    }
    @Override
    public void remove(Livros l) {
        lista.remove(l);
    }

    @Override
    public List listagem() {
        return lista;
    }
}
