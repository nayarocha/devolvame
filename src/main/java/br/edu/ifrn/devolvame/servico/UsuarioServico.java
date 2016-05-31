package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Usuario;
import br.edu.ifrn.devolvame.persistencia.UsuarioRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioServico {
    
    private UsuarioRepositorio repositorio;
    
    @Inject
    public UsuarioServico(UsuarioRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Usuario objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Usuario objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Usuario> iterator() {
       return repositorio.iterator();
    }
}
