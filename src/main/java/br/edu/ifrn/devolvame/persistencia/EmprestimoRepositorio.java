package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepositorio extends CrudRepository<Emprestimo, Long> {

}
