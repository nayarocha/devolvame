package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AutorFabrica {
    public final static String AUTOR1 = "autor1";
    public final static String AUTOR2 = "autor2";
    
    @Inject
    private AutorRepositorio autorRepositorio;
    
    private Autor autor(String nome){
        Autor autor  = autorRepositorio.findByNome(nome);
        if(autor == null){
            autor = Autor.builder().autor(nome).build();
            autorRepositorio.save(autor);
        }
        return autor;
    }
    
    public Autor autor1(){
        return autor(AUTOR1);
    }
    
    public Autor autor2(){
        return autor(AUTOR2);
    }
}
