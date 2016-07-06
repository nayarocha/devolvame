package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Usuario findByEmailUsuario(String email);
    Usuario countByEmailContains(String email);
    
    @Transactional
    void deleteByEmail(String email);
}
