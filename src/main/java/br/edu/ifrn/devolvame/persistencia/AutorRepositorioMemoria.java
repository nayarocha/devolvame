package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class AutorRepositorioMemoria implements AutorRepositorio {
    
    private Set<Autor> objetos = new TreeSet<>();
    
    @Override
    public void save(Autor objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Autor objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Autor> iterator() {
        return objetos.iterator();
    }
}
