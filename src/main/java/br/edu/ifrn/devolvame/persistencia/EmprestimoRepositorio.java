package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import java.util.Iterator;

public interface EmprestimoRepositorio {
    void save(Emprestimo objeto);

    void delete(Emprestimo objeto);
    
    Iterator<Emprestimo> iterator();    
}
