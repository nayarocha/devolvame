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
public class Troca {
    private int idTroca;
    private int idDonoLivro;
    private int idDestinatario;
    private int idLivro;
    
}
