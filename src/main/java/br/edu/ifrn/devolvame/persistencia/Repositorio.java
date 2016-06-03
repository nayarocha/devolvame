package br.edu.ifrn.devolvame.persistencia;

import java.util.Iterator;

public interface Repositorio<O> {
    void save(O object);
  
    void delete(O object);
    
    Iterator<O> iterator();
}
