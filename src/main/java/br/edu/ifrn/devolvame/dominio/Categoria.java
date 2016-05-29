package br.edu.ifrn.devolvame.dominio;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nayarocha
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"nomeCategoria"})
@Builder
class Categoria implements Comparable<Categoria> {
    private int idCategoria;
    private String nomeCategoria;
    private Set<Livro> livrosDaCategoria; 

    @Override
    public int compareTo(Categoria o) {
        return nomeCategoria.compareTo(o.nomeCategoria);
    }
}
