package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Livro;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class LivroRepositorioMemoria implements LivroRepositorio{

    private Set<Livro> objetos = new TreeSet<>();
    
    @Override
    public void save(Livro objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Livro objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Livro> iterator() {
        return objetos.iterator();
    }
}
