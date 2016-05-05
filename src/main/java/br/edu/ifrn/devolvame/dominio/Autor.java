package br.edu.ifrn.devolvame.dominio;
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
public class Autor {
    private int idAutor;
    private String nome;
    
}
