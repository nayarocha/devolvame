package br.edu.ifrn.devolvame.persistencia;

import java.io.Serializable;
import java.util.Iterator;

public interface Repositorio<O, ID extends Serializable> {
    void create(O object);
    O retrieve(ID id);
    
    void update(O object);
    
    void delete(O object);
    
    Iterator<O> Iterator();
}
