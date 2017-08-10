package br.com.arthur.crudsimplesandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

import br.com.arthur.crudsimplesandroid.model.Login;

/**
 * Created by arthur on 10/08/17.
 */

public class LoginDao extends AbstractTemplateDao implements Serializable{

    public LoginDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Login", null, 1);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = "CREATE TABLE Login ( id INTEGER PRIMARY KEY, login TEXT NOT NULL, senha TEXT NOT NULL)";
//        db.execSQL(sql);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        String sql = "DROP TABLE IF EXISTS Login";
//        db.execSQL(sql);
//        onCreate(db);
//    }

    @Override
    protected String getSQLCreate() {
        return "CREATE TABLE Login ( id INTEGER PRIMARY KEY, login TEXT NOT NULL, senha TEXT NOT NULL)";
    }

    @Override
    protected String getSQLUpdate() {
        return "DROP TABLE IF EXISTS Login";
    }

    /**
     * Simples método de inserção
     * @param livro
     */
    public void insert(Login login){
        getDataBaseW().insert("Login", null, setDadosLogin(login));
    }

    /**
     * Simples método de exclusão
     * @param livro
     */
    public void delete(Login livro){
        String[] params = {livro.getId().toString()};
        getDataBaseW().delete("Login", "id = ?", params);
    }

    /**
     * Simples método de edição
     * @param livro
     */
    public void update(Login livro){
        String[] params = {livro.getId().toString()};
        getDataBaseW().update("Login", setDadosLogin(livro), "id= ?", params);
    }

    public ContentValues setDadosLogin(Login login){
        ContentValues dados = new ContentValues();
        dados.put("nome", login.getLogin());
        dados.put("autor", login.getSenha());

        return dados;
    }


}
