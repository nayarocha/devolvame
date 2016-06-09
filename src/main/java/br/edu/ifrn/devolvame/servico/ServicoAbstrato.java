package br.edu.ifrn.devolvame.servico;

import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import javax.inject.Inject;

public abstract class ServicoAbstrato<O extends Object, ID extends Serializable> {
    
    private CrudRepository<O, ID> repositorio;

    @Inject
    public void setRepository(CrudRepository<O, ID> repositorio) {
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
