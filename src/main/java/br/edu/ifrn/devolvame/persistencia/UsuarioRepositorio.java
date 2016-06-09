package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

}
