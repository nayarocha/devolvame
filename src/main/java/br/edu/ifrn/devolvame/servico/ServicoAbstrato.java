package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.persistencia.Repositorio;
import java.io.Serializable;
import java.util.Iterator;


public class ServicoAbstrato<ID extends Serializable, O, R extends Repositorio<ID, O>> implements Servico<ID, O>{
    
    private R repositorio;

    public ServicoAbstrato(R repositorio){
        this.repositorio = repositorio;
    }
    
    @Override
    public void create(ID id, O object) {
        repositorio.create(id, object);
    }

    @Override
    public O retrieve(ID id) {
        return repositorio.retrieve(id);
    }

    @Override
    public void update(ID id, O object) {
        repositorio.update(id, object);
    }

    @Override
    public void delete(ID id) {
        repositorio.delete(id);
    }

    @Override
    public Iterator<O> iterator() {
        return null;
    }
   
    
}
