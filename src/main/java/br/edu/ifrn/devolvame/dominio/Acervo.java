package br.edu.ifrn.devolvame.dominio;
import java.util.Set;
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
@EqualsAndHashCode
public class Acervo {
    private int idAcervo;
    private Usuario idUsuario;
    private Set<Livro> livros;
    
}
