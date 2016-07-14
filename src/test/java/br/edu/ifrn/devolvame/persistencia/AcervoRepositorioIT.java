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
@Test(groups = "acervo")
public class AcervoRepositorioIT extends AbstractTestNGSpringContextTests{
    
    @Inject
    AcervoRepositorio acervoRepositorio;
    
    @Inject
    UsuarioFabrica usuarioFabrica;
    
    @Inject
    AcervoFabrica acervoFabrica;
    
        
    @BeforeMethod
    void deletarTodos(){
        acervoRepositorio.deleteAll();
        assertThat(acervoRepositorio.findAll()).isEmpty();
    }
    
    public void findByUsuarioAcervo(){
        String descricao = "um acervo massa";
        Acervo acervo = acervoFabrica.acervo(descricao);
        
        assertThat(acervoRepositorio.findByDescricao(descricao)).isEqualTo(acervo);
    }


}
