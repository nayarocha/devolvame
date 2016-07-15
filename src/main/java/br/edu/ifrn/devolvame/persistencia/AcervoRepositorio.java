package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface AcervoRepositorio extends CrudRepository<Acervo, Long> {
    Acervo findByDescricao(String descricao);
    Acervo findByUsuario(Usuario usuario);
    //caso nao funcione com (Usuario usuario) passar como 
    //parametro (String email)
}
