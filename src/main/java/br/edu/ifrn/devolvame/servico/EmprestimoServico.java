package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.persistencia.EmprestimoRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmprestimoServico {

    private EmprestimoRepositorio repositorio;
    
    @Inject
    public EmprestimoServico(EmprestimoRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Emprestimo objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Emprestimo objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Emprestimo> iterator() {
       return repositorio.iterator();
    }
}
