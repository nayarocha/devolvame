package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Autor;
import br.edu.ifrn.devolvame.persistencia.AutorRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AutorServico {
    
    private AutorRepositorio repositorio;
    
    @Inject
    public AutorServico(AutorRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Autor objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Autor objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Autor> iterator() {
       return repositorio.iterator();
    }
}
