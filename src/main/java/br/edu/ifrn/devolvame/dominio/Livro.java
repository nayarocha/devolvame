package br.edu.ifrn.devolvame.dominio;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Builder;
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
@EqualsAndHashCode(of = {"titulo"})
@Builder
public class Livro {
    private int idLivro;
    private String titulo;
    private int isbn;
    private String editora;
    private String idioma;
    private String descricao;
    private BufferedImage img;
    private int quant;
    private Categoria categoria;
    private Autor autor;
    //Status do livro - emprestado/disponivel
    private int status;
}
