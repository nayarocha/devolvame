package br.edu.ifrn.devolvame.servico;

import java.util.Iterator;

public interface Servico<O> {
    
    void save(O object);
       
    void delete(O object);
    
    Iterator<O> iterator();
}
