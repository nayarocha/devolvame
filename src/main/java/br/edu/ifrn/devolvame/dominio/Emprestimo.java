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
@EqualsAndHashCode(exclude = {"idEmprestimo"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_emprestimo", name = "ID_SEQUENCE", allocationSize = 1)
public class Emprestimo implements Serializable, Comparable<Emprestimo>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;

    private int idEmprestimo;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario donoLivro;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario destinatario;
    
    @ManyToOne
    private Livro livro;
    private Date data;

    @Override
    public int compareTo(Emprestimo o) {
        int retorno = data.compareTo(o.data);
        
        if(retorno == 0){
            retorno = livro.compareTo(o.livro);
        }
        if(retorno == 0){
            retorno = donoLivro.compareTo(o.donoLivro);
        }
        return retorno;
        
    }
    
}
