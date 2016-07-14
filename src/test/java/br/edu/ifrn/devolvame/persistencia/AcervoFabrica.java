package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AcervoFabrica {
    
    @Inject
    private AcervoRepositorio acervoRepositorio;
    
    public Acervo acervo(String descricao){
        Acervo acrv = acervoRepositorio.findByDescricao(descricao);
        if (acrv == null) {
            acrv = Acervo.builder().descricao(descricao).build();
            acervoRepositorio.save(acrv);
        }
        return acrv;
    }
    
    public Acervo acervoNovo(String descricao){
        return acervo(descricao);
    }

}
