package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Livro;
import java.util.Set;

public interface AcervoRepositorioCustom {
    Set<Acervo> getLivrosDoAcervo(Livro l);
}
