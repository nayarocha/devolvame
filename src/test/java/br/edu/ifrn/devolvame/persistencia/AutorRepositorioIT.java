package br.edu.ifrn.devolvame.persistencia;
import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Autor;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class AutorRepositorioIT extends AbstractTestNGSpringContextTests {
    @Inject 
    private AutorRepositorio autorRepositorio;
    
    public void isNotNull () {
        assertThat(autorRepositorio).isNotNull();
    }
    
    public void save(){
        Autor autor = Autor.builder().autor("cslewis").build();
        autorRepositorio.save(autor);
        
//        assertThat(autorRepositorio.iterator().hasNext()).isEqualTo(autor);
    }
    
    public void delete(){
        Autor autor = Autor.builder().autor("cslewis").build();
        autorRepositorio.save(autor);
        
        autorRepositorio.delete(autor);
        
//        assertThat(autorRepositorio.iterator().hasNext()).isFalse();
    }
}
