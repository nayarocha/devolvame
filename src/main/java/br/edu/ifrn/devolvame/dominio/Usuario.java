package br.edu.ifrn.devolvame.dominio;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nayarocha
 */
@Getter(AccessLevel.NONE)
@Setter(AccessLevel.NONE)
@ToString
@EqualsAndHashCode
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private int telefone;
    private byte[] img;
    private Acervo acervo; 
}
