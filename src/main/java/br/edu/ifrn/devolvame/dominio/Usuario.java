package br.edu.ifrn.devolvame.dominio;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
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
@Getter()
@Setter()
@ToString
@EqualsAndHashCode(of = {"email"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_usuario", name = "ID_SEQUENCE", allocationSize = 1)
public class Usuario implements Serializable, Comparable<Usuario>{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    private int idUsuario;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    private int telefone;
    private BufferedImage img;
    @OneToOne(mappedBy = "usuario")
    private Acervo acervo; 
    @OneToMany(mappedBy = "usuario")
    private Set<Emprestimo> listagemEmprestimo; 
    
    @Override
    public int compareTo(Usuario o) {
        return email.compareTo(o.email);
    }
      
   
    
}
