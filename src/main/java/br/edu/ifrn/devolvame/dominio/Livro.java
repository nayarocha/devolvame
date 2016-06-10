package br.edu.ifrn.devolvame.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(sequenceName = "seq_usuario", name = "ID_SEQUENCE", allocationSize = 1)
public class Livro implements Serializable, Comparable<Livro>{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    private int idLivro;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private int isbn;
    
    private String editora;
    private String idioma;
    private String descricao;
    private byte[] img;
    private int quant;
    
    @ManyToOne
    private Categoria categoria;
    
    private Autor autor;
    //Status do livro - emprestado/disponivel
    @Column(nullable = false)
    private int status;


    @Override
    public int compareTo(Livro o) {
        return titulo.compareTo(o.titulo);
    }
}
