package br.edu.ifrn.devolvame.servico;

import java.io.Serializable;
import java.util.Iterator;

public interface Servico<ID extends Serializable, O> {
    
    void create(ID id, O object);
    
    O retrieve(ID id);
    
    void update(ID id, O object);
    
    void delete(ID id);
    
    Iterator<O> iterator();
}
