package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.persistencia.EmprestimoRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmprestimoServico extends ServicoAbstrato<Long, Emprestimo, EmprestimoRepositorio>{

    @Inject
    public EmprestimoServico(EmprestimoRepositorio repositorio){
        super(repositorio);
    }
}
