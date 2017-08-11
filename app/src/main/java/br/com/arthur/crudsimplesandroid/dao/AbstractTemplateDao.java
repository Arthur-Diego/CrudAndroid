package br.com.arthur.crudsimplesandroid.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.SuperscriptSpan;

import java.io.Serializable;

/**
 * Created by arthur on 10/08/17.
 */

public abstract class AbstractTemplateDao extends SQLiteOpenHelper implements Serializable {

    private static final String NOME_BANCO = "Livraria";
    private static final int VERSION = 1;

    private AbstractTemplateDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOME_BANCO, factory, VERSION);
    }

    public AbstractTemplateDao(Context context){
        super(context, NOME_BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getSQLCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(getSQLUpdate());
        onCreate(db);
    }

    protected abstract String getSQLCreate();

    protected abstract String getSQLUpdate();


    protected SQLiteDatabase getDataBaseW(){
        return getWritableDatabase();
    }

    protected SQLiteDatabase getDataBaseR(){
        return getReadableDatabase();
    }
}
