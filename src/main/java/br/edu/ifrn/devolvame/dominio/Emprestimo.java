package br.edu.ifrn.devolvame.dominio;

import java.util.Date;
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
public class Emprestimo implements Comparable<Emprestimo>{
    private int idEmprestimo;
    private Usuario donoLivro;
    private Usuario destinatario;
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
