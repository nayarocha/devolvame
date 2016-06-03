package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class UsuarioServicoIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private UsuarioServico usuarioServico;
    
    public void repositorioIsNotNull () {
        assertThat(usuarioServico).isNotNull();
    }
    
    public void save () {
        Usuario usuario = Usuario.builder()
                .nome("user01")
                .acervo(Acervo.builder().descricao("minha biblioteca pessoal").build())
                .build();
        
        usuarioServico.save(usuario);
        
        assertThat(usuarioServico.iterator().next()).isEqualTo(usuario);
    }
    
    public void delete () {
        Usuario usuario = Usuario.builder()
                .nome("user01")
                .acervo(Acervo.builder().descricao("minha biblioteca pessoal").build())
                .build();
       
        usuarioServico.save(usuario);
        
       usuarioServico.delete(usuario);
        
       assertThat(usuarioServico.iterator().hasNext()).isFalse();
    }
}
