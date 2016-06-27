package br.edu.ifrn.devolvame.servico;

import java.io.Serializable;
import javax.inject.Inject;
import org.springframework.data.repository.CrudRepository;
public class CrudServico <O extends Object, ID extends Serializable> {
    
    private CrudRepository<O, ID> repositorio;
    
    @Inject
    public void setRepositorio(CrudRepository<O, ID> repositorio) {
        this.repositorio = repositorio;
    }
    
    //deleta todos
    public void deleteAll() {
        repositorio.deleteAll();
    }   
    
    //deleta um
    public void delete(O objeto) {
        repositorio.delete(objeto);
    }
    
    //busca todos
    public Iterable<O> findAll() {
        return repositorio.findAll();
    }
 
    //busca um
    public O findOne(ID id) {
        return repositorio.findOne(id);
    }
    
    // salva todos
    public <S extends O> Iterable<S> save(Iterable<S> objetos) {
        return repositorio.save(objetos);
    }
    
    // salva um 
    public <S extends O> S save(S objeto) {
        return repositorio.save(objeto);
    }
   
}
