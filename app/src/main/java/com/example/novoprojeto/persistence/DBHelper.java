package com.example.novoprojeto.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context){
        super(context, "dbLivro", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        StringBuffer sql = new StringBuffer();
        sql.append("create table livros("+
                "id integer primary key,"+
                "titulo varchar(100),"+
                "autor varchar(100),"+
                "genero varchar(100),"+
                "sinopse varchar(300)"+");");

        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
