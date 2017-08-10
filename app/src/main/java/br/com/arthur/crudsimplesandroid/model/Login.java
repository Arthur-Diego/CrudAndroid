package br.com.arthur.crudsimplesandroid.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by arthur on 10/08/17.
 */

public class Login implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String senha;



}
