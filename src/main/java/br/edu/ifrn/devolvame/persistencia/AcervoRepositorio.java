package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import java.util.Iterator;

public interface AcervoRepositorio {
    
    void save(Acervo objeto);

    void delete(Acervo objeto);
    
    Iterator<Acervo> iterator();

}
