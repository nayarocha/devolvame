package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Livro;
import java.util.Iterator;

public interface LivroRepositorio {
 
    void save(Livro objeto);

    void delete(Livro objeto);
    
    Iterator<Livro> iterator();
}
