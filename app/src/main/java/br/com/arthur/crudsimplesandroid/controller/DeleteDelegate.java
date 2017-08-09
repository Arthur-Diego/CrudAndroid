package br.com.arthur.crudsimplesandroid.controller;

import android.os.Parcelable;

import java.io.Serializable;

import br.com.arthur.crudsimplesandroid.model.Livro;

/**
 * Created by arthur on 09/08/17.
 */

interface DeleteDelegate extends Parcelable {

    public void delete(Livro livro);

}
