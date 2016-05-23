package br.edu.ifrn.devolvame.dominio;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Pedro Rafael
 */
@Test
public class UsuarioTests {

    private static final String EMAIL = "email@a.com";
    private static final String OUTRO_EMAIL = "email@b.com";
    private static final String NOME1 = "nome1";
    private static final String NOME2 = "nome2";

    public void equalAndHashCodeComEmailIgual(){

        assertThat(Usuario.builder().email(EMAIL).nome(NOME1).build())
            .isEqualTo(Usuario.builder().email(EMAIL).nome(NOME2).build());
    }
    
    public void equalsAndHashCdeComEmailsDiferentes(){
        assertThat(Usuario.builder().email(EMAIL).nome(NOME1).build())
            .isNotEqualTo(Usuario.builder().email(OUTRO_EMAIL).nome(NOME1).build());

    }
    
    public void compareTo(){
        Set<Usuario> usuarios = new TreeSet<>();
        
        Usuario user2 = Usuario.builder().nome(NOME2).build();
        usuarios.add(user2);
        Usuario user1 = Usuario.builder().nome(NOME1).build();
        usuarios.add(user1);
        
        assertThat(usuarios.iterator().next()).isEqualTo(user1);
    }
}
    