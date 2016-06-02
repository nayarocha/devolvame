package br.edu.ifrn.devolvame.persistencia;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RepositorioMemoria<ID extends Serializable,O> implements Repositorio<ID, O>{
    
    private HashMap<ID, O> container = new HashMap<>();
    
    @Override
    public void create(ID id, O object){
        if (this.containsObject(id)){
            throw new IllegalArgumentException();
        }
        container.put(id, object);
    }
    
    @Override
    public O retrieve(ID id){
        return container.get(id);
    }
    
    @Override
    public void update(ID id, O object){
        if(!this.containsObject(id)){
            throw new NoSuchElementException();
        }
        container.put(id, object);
    }
    
    @Override
    public void delete(ID id){
        if (!this.containsObject(id)){
            throw new NoSuchElementException();
        }
        container.remove(id);
    }
    
    @Override
    public Iterator<O> Iterator() {
        return null;
    }
    
    private boolean containsObject(ID id){
        return container.containsKey(id);
    }

   
}
