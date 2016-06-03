package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.dominio.Livro;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class LivroServicoIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private LivroServico livroServico;
    
    public void repositorioIsNotNull () {
        assertThat(livroServico).isNotNull();
    }
    
    public void save () {
        Livro livro = Livro.builder()
                .titulo("HarryPotter")
                .categoria(Categoria.builder().nomeCategoria("Aventura").build())
                .build();
        
        livroServico.save(livro);
        
        assertThat(livroServico.iterator().next()).isEqualTo(livro);
    }
    
    public void delete () {
        Livro livro = Livro.builder()
                .titulo("HarryPotter")
                .categoria(Categoria.builder().nomeCategoria("Aventura").build())
                .build();
       
       livroServico.save(livro);
        
       livroServico.delete(livro);
        
       assertThat(livroServico.iterator().hasNext()).isFalse();
    }
}
