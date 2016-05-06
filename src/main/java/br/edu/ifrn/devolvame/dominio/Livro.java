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
public class Livro {
    private int idLivro;
    private String titulo;
    private int isbn;
    private String editora;
    private String idioma;
    private String descricao;
    private byte[] img;
    private int quant;
    private Categoria categoria;
    private Autor autor;
    
}
