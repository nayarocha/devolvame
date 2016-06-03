package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class CategoriaServicoIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private CategoriaServico categoriaServico;
    
    public void repositorioIsNotNull () {
        assertThat(categoriaServico).isNotNull();
    }
    
    public void save () {
        Categoria categoria = Categoria.builder().nomeCategoria("biografia").build();
        categoriaServico.save(categoria);
        
        assertThat(categoriaServico.iterator().next()).isEqualTo(categoria);
    }
    
    public void delete () {
       Categoria categoria = Categoria.builder().nomeCategoria("biografia").build();
       categoriaServico.save(categoria);
        
       categoriaServico.delete(categoria);
        
       assertThat(categoriaServico.iterator().hasNext()).isFalse();
    }
}
