package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepositorio extends CrudRepository<Autor, Long> {

}
