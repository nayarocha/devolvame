package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class CategoriaRepositorioIT extends AbstractTestNGSpringContextTests{
    @Inject 
    private CategoriaRepositorio categoriaRepositorio;
    
    
    public void isNotNull () {
        assertThat(categoriaRepositorio).isNotNull();
    }
    
    public void save(){
        Categoria categoria = Categoria.builder().nomeCategoria("biografia").build();
        categoriaRepositorio.save(categoria);
        
        assertThat(categoriaRepositorio.iterator().hasNext()).isEqualTo(categoria);
    }
    
    
    public void delete(){
        Categoria categoria = Categoria.builder().nomeCategoria("biografia").build();
        categoriaRepositorio.save(categoria);
        
        categoriaRepositorio.delete(categoria);
        
        assertThat(categoriaRepositorio.iterator().hasNext()).isFalse();
    }
}
