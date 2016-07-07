package br.edu.ifrn.devolvame.servico;

import java.io.Serializable;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional()
public class CrudServico <O extends Object, ID extends Serializable> {
    
    private CrudRepository<O, ID> repositorio;
    
    @Inject
    public void setRepositorio(CrudRepository<O, ID> repositorio) {
        this.repositorio = repositorio;
    }
    
    @Transactional
    public void deleteAll() {
        repositorio.deleteAll();
    }   
    
    @Transactional  
    public void delete(O objeto) {
        repositorio.delete(objeto);
    }
    
    public Iterable<O> findAll() {
        return repositorio.findAll();
    }
 
    //busca um
    public O findOne(ID id) {
        return repositorio.findOne(id);
    }
    
    @Transactional
    public <S extends O> Iterable<S> save(Iterable<S> objetos) {
        return repositorio.save(objetos);
    }
    
    @Transactional
    public <S extends O> S save(S objeto) {
        return repositorio.save(objeto);
    }
   
}
