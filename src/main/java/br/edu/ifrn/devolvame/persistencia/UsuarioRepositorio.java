package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Usuario countByEmail(String email);
    

    void deleteByEmail(String email);
}
