package br.edu.ifrn.devolvame.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"id"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_emprestimo", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Emprestimo implements Serializable, Comparable<Emprestimo>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;

    //private int idEmprestimo;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario donoLivro;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario destinatario;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Livro livro;
    @JoinColumn(nullable = false)
    private Date data;

   
    
    @Override
    public int compareTo(Emprestimo o) {
        int result = 0;
        if (donoLivro != null && o.donoLivro != null) {
			result = this.donoLivro.compareTo(o.donoLivro);
		}
		else if (this.donoLivro == null && o.donoLivro == null) {
			result = 0;
		}
		else if (this.donoLivro == null) {
			result = -1;
		}
		else {
			result = +1;
		}
		return result;
    }
    
    
    
    public void verificarUsuario() {
        
        if (donoLivro instanceof Usuario) {
             throw new IllegalArgumentException("Dono do Livro não poder ser do tipo Usuário: " + donoLivro);         
        }
        if (destinatario instanceof Usuario) {
            throw new IllegalArgumentException("Destinatário não pode ser do tipo Usuário: " + destinatario);
        }
    }
}
