package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import org.springframework.data.repository.CrudRepository;

public interface AcervoRepositorio extends CrudRepository<Acervo, Long> {
    Acervo findByDescricao(String descricao);
}
