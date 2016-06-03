package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.persistencia.Repositorio;
import java.util.Iterator;

public abstract class ServicoAbstrato<O> implements Servico<O>{
    
    private Repositorio<O> repositorio;

    public ServicoAbstrato(Repositorio<O> repositorio){
        this.repositorio = repositorio;
    }
    
    @Override
    public void save(O object){
        repositorio.save(object);
    }

    @Override
    public void delete(O object){
        repositorio.delete(object);
    }

    @Override
    public Iterator<O> iterator(){
        return repositorio.iterator();
    }
}
