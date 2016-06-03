package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Acervo;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class AcervoRepositorioIT extends AbstractTestNGSpringContextTests{
    @Inject 
    private AcervoRepositorio acervoRepositorio;
      
    public void isNotNull () {
        assertThat(acervoRepositorio).isNotNull();
    }
    
    public void save(){
        Acervo acervo = Acervo.builder().descricao("Minha biblioteca pessoal").build();
        acervoRepositorio.save(acervo);
        
        assertThat(acervoRepositorio.iterator().hasNext()).isEqualTo(acervo);
    }
    
    
    public void delete(){
        Acervo acervo = Acervo.builder().descricao("Minha biblioteca pessoal").build();
        acervoRepositorio.save(acervo);
        
        acervoRepositorio.delete(acervo);
        
        assertThat(acervoRepositorio.iterator().hasNext()).isFalse();
    }
}
