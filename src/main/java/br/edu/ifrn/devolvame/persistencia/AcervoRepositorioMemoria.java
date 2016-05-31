package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class AcervoRepositorioMemoria implements AcervoRepositorio {
    
    private Set<Acervo> objetos = new TreeSet<>();
    
    @Override
    public void save(Acervo objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Acervo objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Acervo> iterator() {
        return objetos.iterator();
    }
}
