package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Categoria;
import java.util.Iterator;

public interface CategoriaRepositorio {
    void save(Categoria objeto);

    void delete(Categoria objeto);
    
    Iterator<Categoria> iterator();
}
