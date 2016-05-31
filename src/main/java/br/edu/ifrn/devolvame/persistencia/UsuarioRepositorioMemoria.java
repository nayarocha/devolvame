package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Usuario;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class UsuarioRepositorioMemoria implements UsuarioRepositorio{
    
    private Set<Usuario> objetos = new TreeSet<>();
    
    @Override
    public void save(Usuario objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Usuario objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Usuario> iterator() {
        return objetos.iterator();
    }
}
