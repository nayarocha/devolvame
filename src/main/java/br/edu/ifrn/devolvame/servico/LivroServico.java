package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.persistencia.LivroRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LivroServico extends ServicoAbstrato<Long, Livro, LivroRepositorio>{
    
    @Inject
    public LivroServico(LivroRepositorio repositorio){
        super(repositorio);
    }
}
