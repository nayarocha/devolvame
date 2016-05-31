package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Named;

@Named
public class EmprestimoRepositorioMemoria implements EmprestimoRepositorio{
    
    private Set<Emprestimo> objetos = new TreeSet<>();
    
    @Override
    public void save(Emprestimo objeto) {
        objetos.add(objeto);
    }

    @Override
    public void delete(Emprestimo objeto) {
        objetos.remove(objeto);
    }

    @Override
    public Iterator<Emprestimo> iterator() {
        return objetos.iterator();
    }
}
