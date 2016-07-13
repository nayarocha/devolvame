package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Usuario;
import static br.edu.ifrn.devolvame.persistencia.UsuarioFabrica.USER1;
import static br.edu.ifrn.devolvame.persistencia.UsuarioFabrica.USER2;
import static br.edu.ifrn.devolvame.persistencia.UsuarioFabrica.USER3;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "usuario")
public class UsuarioRepositorioIT extends AbstractTestNGSpringContextTests{
    @Inject
    private UsuarioRepositorio usuarioRepositorio;
    
    @Inject
    private UsuarioFabrica usuarioFabrica;
    
    @BeforeMethod
    void deletarTodos(){
        usuarioRepositorio.deleteAll();
        assertThat(usuarioRepositorio.findAll()).isEmpty();
    }
    
    public void repositorioNaoEhNulo(){
        assertThat(usuarioRepositorio).isNotNull();
    }
    
    public void findByEmail(){
        Usuario user1 = usuarioFabrica.adolfo();
        Usuario user2 = usuarioFabrica.pedro();
        
        assertThat(usuarioRepositorio.findByEmail(USER3)).isEqualTo(user1);
        assertThat(usuarioRepositorio.findByEmail(USER1)).isEqualTo(user2);
    }
    
    /*public void countByEmail(){
        usuarioFabrica.adolfo();
        usuarioFabrica.pedro();
        
        assertThat(usuarioRepositorio.countByEmail(USER1.contains())
    }
    */
    public void deleteByEmail(){
        usuarioFabrica.adolfo();
        
        usuarioRepositorio.deleteByEmail(USER3);
        
        assertThat(usuarioRepositorio.findAll()).isEmpty();
    }
}
