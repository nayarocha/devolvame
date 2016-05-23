package br.edu.ifrn.devolvame.dominio;
import java.awt.image.BufferedImage;
import java.util.Set;
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
public class Usuario implements /*Serializable,*/ Comparable<Usuario>{
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private int telefone;
    private BufferedImage img;
    private Acervo acervo; 
    
    private Set<Emprestimo> listagemEmprestimo; 
    
    @Override
    public int compareTo(Usuario o) {
        return nome.compareTo(o.nome);//To change body of generated methods, choose Tools | Templates.
    }
      
   
    
}
