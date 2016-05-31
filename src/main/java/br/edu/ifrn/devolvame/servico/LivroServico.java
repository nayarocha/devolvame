package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.persistencia.LivroRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LivroServico {
    
    private LivroRepositorio repositorio;
    
    @Inject
    public LivroServico(LivroRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Livro objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Livro objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Livro> iterator() {
       return repositorio.iterator();
    }
}
