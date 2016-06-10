package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class UsuarioRepositorioIT extends AbstractTestNGSpringContextTests{
    @Inject 
    private UsuarioRepositorio usuarioRepositorio;
    
    @Inject
    private FabricaDominio dominioFactory;
    
    
    public void isNotNull () {
        assertThat(usuarioRepositorio).isNotNull();
    }
    
    public void save(){
        Usuario usuario = Usuario.builder().nome("User01").build();
        usuarioRepositorio.save(usuario);
        
//        assertThat(usuarioRepositorio.iterator().hasNext()).isEqualTo(usuario);
    }
    
    
    public void delete(){
        Usuario usuario = Usuario.builder().nome("User01").build();
        usuarioRepositorio.save(usuario);
        
        usuarioRepositorio.delete(usuario);
        
//        assertThat(usuarioRepositorio.iterator().hasNext()).isFalse();
    }
}
