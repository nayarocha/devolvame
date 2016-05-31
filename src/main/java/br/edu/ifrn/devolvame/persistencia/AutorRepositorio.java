package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import java.util.Iterator;

public interface AutorRepositorio {
    
    void save(Autor objeto);

    void delete(Autor objeto);
    
    Iterator<Autor> iterator();
    
}
