package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.persistencia.CrudRepositorio;
import java.io.Serializable;
import javax.inject.Inject;

public abstract class ServicoAbstrato<O extends Object, ID extends Serializable> {
    
    private CrudRepositorio<O, ID> repositorio;

    @Inject
    public void setRepositorio(CrudRepositorio<O, ID> repositorio) {
         this.repositorio = repositorio;
     }
 
    public void save(O objeto) {
        // realizar verificacoes de negocio
                
        // delega a persistencia para o repositorio
        repositorio.save(objeto);
    }
    
    public void delete(O objeto) {
        // realizar verificacoes de negocio
                
        // delega a persistencia para o repositorio
        repositorio.delete(objeto);
    }
    
    public Iterable<O> findAll() {
        return repositorio.findAll();
    }
    
    public void deleteAll() {
        // realizar verificacoes de negocio
                
        // delega a persistencia para o repositorio
        repositorio.deleteAll();
    }
}
