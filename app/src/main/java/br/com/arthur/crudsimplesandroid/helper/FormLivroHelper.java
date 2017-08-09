package br.com.arthur.crudsimplesandroid.helper;

import android.util.Log;
import android.widget.EditText;

import java.io.Serializable;
import java.util.List;

import br.com.arthur.crudsimplesandroid.R;
import br.com.arthur.crudsimplesandroid.controller.FormLivroActivity;
import br.com.arthur.crudsimplesandroid.model.Livro;

/**
 * Created by arthur on 08/08/17.
 */

public class FormLivroHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient EditText txtNome;
    private transient EditText txtAutor;

    private Livro livro;

    private final String TAG = "LIVRO";


    public FormLivroHelper(FormLivroActivity activity) {

        txtNome = (EditText)  activity.findViewById(R.id.txtNome);
        txtAutor = (EditText) activity.findViewById(R.id.txtAutor);
        livro = new Livro();

    }

    public Livro getLivro(){
        livro.setNome(txtNome.getText().toString());
        livro.setAutor(txtAutor.getText().toString());

        return livro;
    }

    public void preencheLivro(Livro livro){

        txtNome.setText(livro.getNome());
        txtAutor.setText(livro.getAutor());

        this.livro = livro;
    }

    public void imprimeLivros(List<Livro> listLivros){

        for(Livro  livro: listLivros){

            Log.i(TAG, livro.toString());

        }

    }
}
