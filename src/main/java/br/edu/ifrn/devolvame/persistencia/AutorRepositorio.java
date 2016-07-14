package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepositorio extends CrudRepository<Autor, Long> {
    
    Autor findByNome(String nome);
    
    @Transactional
    void deleteByNome(String nome);
}
