package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Categoria;
import org.springframework.data.repository.CrudRepository;


public interface CategoriaRepositorio extends CrudRepository<Categoria, Long> {

}
