package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.dominio.Livro;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepositorio extends CrudRepository<Emprestimo, Long> {
    Emprestimo findBydonoLivro(Long id);
    Emprestimo findByLivro(Livro livro);
    
}
