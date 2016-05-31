package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.persistencia.CategoriaRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CategoriaServico {

    private CategoriaRepositorio repositorio;
    
    @Inject
    public CategoriaServico(CategoriaRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Categoria objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Categoria objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Categoria> iterator() {
       return repositorio.iterator();
    }
}
