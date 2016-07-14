package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Livro;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AcervoFabrica {
    
    @Inject
    private AcervoRepositorio acervoRepositorio;
    
    public Acervo acervo(String descricao){
        Acervo acrv = acervoRepositorio.findByDescricao(descricao);
        if (acrv == null) {
            TreeSet<Livro> livros = new TreeSet<>();
            acrv = Acervo.builder()
                    .descricao(descricao)
                    .livros(livros)
                    .build();
            acervoRepositorio.save(acrv);
        }
        return acrv;
    }
    
    public Acervo acervoNovo(String descricao){
        return acervo(descricao);
    }

}
