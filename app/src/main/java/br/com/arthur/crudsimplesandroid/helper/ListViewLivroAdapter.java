package br.com.arthur.crudsimplesandroid.helper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.arthur.crudsimplesandroid.R;
import br.com.arthur.crudsimplesandroid.model.Livro;

/**
 * Created by arthur on 11/08/17.
 */

public class ListViewLivroAdapter extends ArrayAdapter<Livro> {

    List<Livro> livros;

    private Context context;

    public ListViewLivroAdapter(Context context, List<Livro> livros, int id) {

        super(context, id);
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros != null ? livros.size() : 0;
    }

//    @Override
//    public Object getItem(int i) {
//        return livros.get(i);
//    }


    @Nullable
    @Override
    public Livro getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewConvert, ViewGroup viewGroup) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_listview_livro, viewGroup, false);

        TextView txtViewNome = view.findViewById(R.id.txtLivroNome);

        ImageView img = view.findViewById(R.id.imgPlaneta);

        img.setImageResource(R.drawable.books);

        Livro livro = livros.get(i);

        txtViewNome.setText(livro.getNome());

        return view;
    }


}
