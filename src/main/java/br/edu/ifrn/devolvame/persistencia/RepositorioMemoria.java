package br.edu.ifrn.devolvame.persistencia;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class RepositorioMemoria<O> implements Repositorio<O> {
    
    private Set<O> container = new TreeSet<>();

    @Override
    public void save(O object) {
        container.add(object);
    }

    @Override
    public void delete(O object) {
        container.remove(object);
    }

    @Override
    public Iterator<O> iterator(){
        return container.iterator();
    }
}
