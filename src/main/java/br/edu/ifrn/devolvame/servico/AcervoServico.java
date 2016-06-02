package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.persistencia.AcervoRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AcervoServico extends ServicoAbstrato<Long, Acervo, AcervoRepositorio>{

    @Inject
    public AcervoServico(AcervoRepositorio repositorio){
        super(repositorio);
    }
}
