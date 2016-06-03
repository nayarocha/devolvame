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
public class AcervoServicoIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private AcervoServico acervoServico;
    
    public void repositorioIsNotNull () {
        assertThat(acervoServico).isNotNull();
    }
    
    public void save () {
        Acervo acervo = Acervo.builder()
               .descricao("Minha biblioteca pessoal")
               .usuario(Usuario.builder().id(0l).build())
               .build();
        
        acervoServico.save(acervo);
        
        assertThat(acervoServico.iterator().next()).isEqualTo(acervo);
    }
    
    public void delete () {
        Acervo acervo = Acervo.builder()
               .descricao("Minha biblioteca pessoal")
               .usuario(Usuario.builder().id(0l).build())
               .build();
       
        acervoServico.save(acervo);
        
        acervoServico.delete(acervo);
        
       assertThat(acervoServico.iterator().hasNext()).isFalse();
    }    
}
