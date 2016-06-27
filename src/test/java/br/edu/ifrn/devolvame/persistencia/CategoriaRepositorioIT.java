package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "categoria")
public class CategoriaRepositorioIT extends AbstractTestNGSpringContextTests{
    @Inject
    private CategoriaRepositorio categoriaRepositorio;
    
    @Inject
    private CategoriaFabrica categoriaFabrica;
    
    @BeforeMethod
    void deletarTodos(){
        categoriaRepositorio.deleteAll();
        assertThat(categoriaRepositorio.findAll()).isEmpty();
    }
    
    public void repositorioNaoEhNulo(){
        assertThat(categoriaRepositorio).isNotNull();
    }
    
    public void deletarUm(){
       Categoria categoria = categoriaFabrica.biografia();
       
       categoriaRepositorio.delete(categoria);
       
        assertThat(categoriaRepositorio.findOne(categoria.getId())).isNull();
    }
    
    public void salvarUm(){
        Categoria categoria = Categoria.builder().nomeCategoria(CategoriaFabrica.BIOGRAFIA).build();
        
        categoriaRepositorio.save(categoria);
    
        assertThat(categoriaRepositorio.findAll().iterator().next()).isEqualTo(categoria);
    }
}
