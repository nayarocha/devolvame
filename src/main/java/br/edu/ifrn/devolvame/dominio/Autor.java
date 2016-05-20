package br.edu.ifrn.devolvame.dominio;
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
@EqualsAndHashCode(of="autor")
@Builder
public class Autor {
    private int idAutor;
    private String autor;
    
}
