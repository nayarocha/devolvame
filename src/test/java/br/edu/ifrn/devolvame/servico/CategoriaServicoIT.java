package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.persistencia.CategoriaFabrica;
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
public class CategoriaServicoIT extends AbstractTestNGSpringContextTests{
    @Inject 
    CategoriaServico categoriaServico; 
    
    @BeforeMethod
    void deletarTodos(){
        categoriaServico.deleteAll();
        assertThat(categoriaServico.findAll()).isEmpty();
    }
    
    public void repositorioNaoEhNulo(){
        assertThat(categoriaServico).isNotNull();
    }
    
    public void salvarUm(){
        Categoria categoria = Categoria.builder().nomeCategoria(CategoriaFabrica.BIOGRAFIA).build();
        
        categoriaServico.save(categoria);
    
        assertThat(categoriaServico.findAll().iterator().next()).isEqualTo(categoria);
    }
    
    public void deletarUm(){
       
       Categoria categoria = Categoria.builder().nomeCategoria(CategoriaFabrica.BIOGRAFIA).build();
        
       categoriaServico.delete(categoria);
       
       assertThat(categoriaServico.findAll().iterator().hasNext()).isFalse();
    }
    
}
