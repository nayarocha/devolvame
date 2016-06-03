package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Livro;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class LivroRepositorioIT extends AbstractTestNGSpringContextTests{
    
    @Inject 
    private LivroRepositorio livroRepositorio;
    
    
    public void isNotNull () {
        assertThat(livroRepositorio).isNotNull();
    }
    
    public void save(){
        Livro livro = Livro.builder().titulo("HarryPotter").build();
        livroRepositorio.save(livro);
        
        assertThat(livroRepositorio.iterator().hasNext()).isEqualTo(livro);
    }
    
    
    public void delete(){
        Livro livro = Livro.builder().titulo("HarryPotter").build();
        livroRepositorio.save(livro);
        
        livroRepositorio.delete(livro);
        
        assertThat(livroRepositorio.iterator().hasNext()).isFalse();
    }
}
