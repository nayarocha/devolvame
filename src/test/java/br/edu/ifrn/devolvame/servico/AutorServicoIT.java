package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Autor;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class AutorServicoIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private AutorServico autorServico;
    
    public void repositorioIsNotNull () {
        assertThat(autorServico).isNotNull();
    }
    
    public void save () {
        Autor autor = Autor.builder().autor("csLewis").build();
        autorServico.save(autor);
        
//        assertThat(autorServico.iterator().next()).isEqualTo(autor);
    }
    
    public void delete () {
       Autor autor = Autor.builder().autor("csLewis").build();
       autorServico.save(autor);
        
       autorServico.delete(autor);
        
//       assertThat(autorServico.iterator().hasNext()).isFalse();
    }
}
