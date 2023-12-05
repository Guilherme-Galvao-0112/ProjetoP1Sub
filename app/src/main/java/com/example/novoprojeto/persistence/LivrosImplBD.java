package com.example.novoprojeto.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.novoprojeto.model.Livros;

import java.util.ArrayList;
import java.util.List;

public class LivrosImplBD implements LivrosDao{
    DBHelper db;
    @Override
    public void salvar(Livros l){
        ContentValues dados = new ContentValues();
        dados.put("titulo",l.getTitulo());
        db.getWritableDatabase().insertOrThrow("livros",null,dados);
        db.close();
    }
    @Override
    public void editar(Livros l){
        ContentValues dados = new ContentValues();
        dados.put("titulo",l.getTitulo());
        db.getWritableDatabase().update("livros",dados,"id=?",new String[]{l.getId()+""});
        db.close();
    }
    @Override
    public void remove(Livros l){
        db.getWritableDatabase().delete("livros","id?",new String[]{l.getId()+""});
        db.close();
    }

    public LivrosImplBD(Context context){
        this.db=new DBHelper(context);
    }

    @Override
    public List listagem(){
        List retorna = new ArrayList();
        String colunas[]= {"id","titulo","autor","genero","sinopse"};
        Cursor cursor = db.getReadableDatabase().
                query("livros",colunas,null,null,null,null,
                        "titulo,"+"autor,"+"genero,"+"sinopse");
        final int COLUMN_ID=0, COLUMN_TITULO=1, COLUMN_AUTOR=1,COLUMN_GENERO=1,COLUMN_SINOPSE=1;
        while(cursor.moveToNext()){
            Livros l = new Livros();
            l.setId(cursor.getInt(COLUMN_ID));
            l.setTitulo(cursor.getString(COLUMN_TITULO));
            l.setAutor(cursor.getString(COLUMN_AUTOR));
            l.setGenero(cursor.getString(COLUMN_GENERO));
            l.setSinopse(cursor.getString(COLUMN_SINOPSE));
            retorna.add(l);
        }
        db.close();
        return retorna;
    }
}
