package br.com.arthur.crudsimplesandroid.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import br.com.arthur.crudsimplesandroid.R;
import br.com.arthur.crudsimplesandroid.dao.LivroDao;
import br.com.arthur.crudsimplesandroid.helper.ListViewLivroAdapter;
import br.com.arthur.crudsimplesandroid.model.Livro;
import br.com.arthur.crudsimplesandroid.utils.AlertUtils;

public class ListLivroActivit extends AppCompatActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    private LivroDao dao;

    ListView list;

    DeleteDelegate delegate;

    ArrayAdapter<Livro> livrosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_livro);
        dao = new LivroDao(this);
        List<Livro> livros = dao.selectLivros();
        list = (ListView) findViewById(R.id.listLivro);
        clickItemList();
        clickSeguraParaExcluir();
        Intent intent = getIntent();
        livrosAdapter = new ListViewLivroAdapter(this, livros, android.R.layout.simple_list_item_1);
        list.setAdapter(livrosAdapter);
    }

    public void clickItemList(){
        list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Planeta p = (Planeta) parent.getAdapter().getItem(idx);

                Livro livro = (Livro) livrosAdapter.getItem(i);

               // Livro livro = (Livro) list.getItemAtPosition(i);
                Intent intentVaiPraForm = new Intent(ListLivroActivit.this, FormLivroActivity.class);
                intentVaiPraForm.putExtra("livro",  livro);
                startActivity(intentVaiPraForm);
            }
        });

    }

    public void clickSeguraParaExcluir(){
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertUtils aler = new AlertUtils();
                aler.messageDelete(ListLivroActivit.this, R.drawable.books, "Excluir Livro", "Deseja exlcuir esse livro?", clickSim(i), clickNao());
                return true;
            }
        });
    }

    public DialogInterface.OnClickListener clickSim(final int positionItem){
        return new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Livro liv = (Livro)list.getItemAtPosition(positionItem);

                livrosAdapter.remove(liv);
                livrosAdapter.notifyDataSetChanged();
                dao.delete(liv);
                list.deferNotifyDataSetChanged();
            }
        };
    }

    public DialogInterface.OnClickListener clickNao(){
        return new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        };
    }
}
