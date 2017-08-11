package br.com.arthur.crudsimplesandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.arthur.crudsimplesandroid.model.Livro;

/**
 * Created by arthur on 08/08/17.
 * @author Arthur Diego
 */

public class LivroDao extends AbstractTemplateDao {

    private static final long serialVersionUID = 1L;

    public LivroDao(Context context) {
        super(context);
    }

    @Override
    protected String getSQLCreate() {
        String sql = "CREATE TABLE Livro ( id INTEGER PRIMARY KEY, nome TEXT NOT NULL, autor TEXT NOT NULL)";
        return  sql;
    }

    @Override
    protected String getSQLUpdate() {
        String sql = "DROP TABLE IF EXISTS Livro";
        return sql;
    }

    /**
     * Simples método de inserção
     * @param livro
     */
    public void insert(Livro livro){
        getDataBaseW().insert("Livro", null, setDadosLivro(livro));
    }

    /**
     * Simples método de exclusão
     * @param livro
     */
    public void delete(Livro livro){
        String[] params = {livro.getId().toString()};
        getDataBaseW().delete("Livro", "id = ?", params);
    }

    /**
     * Simples método de edição
     * @param livro
     */
    public void update(Livro livro){
        String[] params = {livro.getId().toString()};
        getDataBaseW().update("Livro", setDadosLivro(livro), "id= ?", params);
    }

    public List<Livro> selectLivros(){
        String sql = "SELECT * FROM Livro";
        Cursor c = getDataBaseR().rawQuery(sql, null);

        List<Livro> livros = new ArrayList<>();

        while(c.moveToNext()){
            Livro livro = new Livro();
            livro.setId(c.getLong(c.getColumnIndex("id")));
            livro.setNome(c.getString(c.getColumnIndex("nome")));
            livro.setAutor(c.getString(c.getColumnIndex("autor")));

            livros.add(livro);
        }
        c.close();

        return livros;
    }

    public ContentValues setDadosLivro(Livro livro){
        ContentValues dados = new ContentValues();
        dados.put("nome", livro.getNome());
        dados.put("autor", livro.getAutor());

        return dados;
    }

}
