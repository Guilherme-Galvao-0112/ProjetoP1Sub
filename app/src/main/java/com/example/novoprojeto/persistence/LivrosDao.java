package com.example.novoprojeto.persistence;

import com.example.novoprojeto.model.Livros;

import java.util.List;

public interface LivrosDao{
    public void salvar(Livros l);
    public void editar(Livros l);
    public void remove(Livros l);
    public List listagem();


}
