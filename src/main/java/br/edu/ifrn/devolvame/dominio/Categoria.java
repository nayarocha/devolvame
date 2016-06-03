package br.edu.ifrn.devolvame.dominio;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Entity
@SequenceGenerator(sequenceName = "seq_categoria", name = "ID_SEQUENCE", allocationSize = 1)
public class Categoria implements Comparable<Categoria>, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    @Column(nullable = false)
    private String nomeCategoria;
   
    @OneToMany(mappedBy =  "categoria")
    private Set<Livro> livrosDaCategoria; 

    @Override
    public int compareTo(Categoria o) {
        return nomeCategoria.compareTo(o.nomeCategoria);
    }
}
