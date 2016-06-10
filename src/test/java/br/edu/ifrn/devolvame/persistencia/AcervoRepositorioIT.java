package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Acervo;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class AcervoRepositorioIT extends AbstractTestNGSpringContextTests{
    
    @Inject 
    private AcervoRepositorio acervoRepositorio;
    
    @Inject
    private FabricaDominio dominioFactory;
    
    @BeforeMethod
    void deletarTodos()
    {
        acervoRepositorio.deleteAll();
        assertThat(acervoRepositorio.findAll()).isEmpty();
    }
    
    public void isNotNull () {
        assertThat(acervoRepositorio).isNotNull();
    }
    
    public void save(){
        Acervo acervo = Acervo.builder().descricao("Minha biblioteca pessoal").build();
        
        acervoRepositorio.save(acervo);
        
        assertThat(acervoRepositorio.findAll().iterator().next()).isEqualTo(acervo);
    }
    
    
    public void delete(){
        Acervo acervo = dominioFactory.acervo();
        
        acervoRepositorio.delete(acervo);
        
        assertThat(acervoRepositorio.findOne(acervo.getId())).isNull();
    }
}
