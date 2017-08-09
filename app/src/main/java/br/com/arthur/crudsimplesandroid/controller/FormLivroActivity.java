package br.com.arthur.crudsimplesandroid.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import br.com.arthur.crudsimplesandroid.R;
import br.com.arthur.crudsimplesandroid.dao.LivroDao;
import br.com.arthur.crudsimplesandroid.helper.FormLivroHelper;
import br.com.arthur.crudsimplesandroid.model.Livro;

public class FormLivroActivity extends AppCompatActivity implements DeleteDelegate {

    private static final long serialVersionUID = 1L;

    private Button btnSalvar;

    private FormLivroHelper helper;

    private LivroDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_livro);

       // Context context = getBaseContext();

        dao = new LivroDao(this);//Instancia de livroDao
        helper = new FormLivroHelper(FormLivroActivity.this);//Instancia da classe Helper


        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        salvarLivro(btnSalvar);

        Livro liv = (Livro) getIntent().getSerializableExtra("livro");

        if(liv != null){
            helper.preencheLivro(liv);
        }

    }

    public void salvarLivro(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(helper.getLivro().getId() != null){
                    dao.update(helper.getLivro());
                }else {
                    dao.insert(helper.getLivro());
                }
                helper.imprimeLivros(dao.selectLivros());

                Intent intent = new Intent(FormLivroActivity.this, ListLivroActivit.class);

                intent.putExtra("this", FormLivroActivity.this);
                startActivity(intent);

            }
        });
    }

    private Context obterContext() {
        return this;
    }


    @Override
    public void delete(Livro livro) {
        dao.delete(livro);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        @Override
        public FormLivroActivity createFromParcel(Parcel in)
        {
            return new FormLivroActivity();
        }

        @Override
        public Object[] newArray(int size)
        {
            return new FormLivroActivity[size];
        }
    };
}
