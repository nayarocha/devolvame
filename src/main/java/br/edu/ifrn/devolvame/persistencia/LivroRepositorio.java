package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepositorio extends CrudRepository<Livro, Long> {
    
    
    Livro findByStatus (int status);
    Livro findByTitulo (String titulo);
    
}


