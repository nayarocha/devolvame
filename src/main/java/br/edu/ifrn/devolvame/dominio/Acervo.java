package br.edu.ifrn.devolvame.dominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@EqualsAndHashCode(of = "livros")
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_acervo", name = "ID_SEQUENCE", allocationSize = 1)
public class Acervo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    @OneToOne
    private Usuario usuario;
    
    @OneToMany
    private Set<Livro> livros;
    private String descricao;
    
}
