package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Autor;
import br.edu.ifrn.devolvame.persistencia.AutorRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AutorServico extends ServicoAbstrato<Autor>{

    @Inject
        public AutorServico(AutorRepositorio repositorio){
        super(repositorio);
    }
}
