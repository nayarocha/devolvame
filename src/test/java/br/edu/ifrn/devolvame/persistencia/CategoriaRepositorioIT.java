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
    private FabricaDominio dominioFactory;
    
    @BeforeMethod
    void deletarTodos()
    {
        categoriaRepositorio.deleteAll();
        assertThat(categoriaRepositorio.findAll()).isEmpty();
    }
    

    public void isNotNull () {
        assertThat(categoriaRepositorio).isNotNull();
    }
    
    public void save(){
        Categoria categoria = Categoria.builder().nomeCategoria("biografia").build();
        
        // executa a operacao a ser testada
        categoriaRepositorio.save(categoria);
        
        assertThat(categoriaRepositorio.findAll().iterator().next()).isEqualTo(categoria);
    }
    
    
    public void delete(){
        Categoria categoria = dominioFactory.ficcao();
        
        // executa a operacao a ser testada
        categoriaRepositorio.delete(categoria);
        
        assertThat(categoriaRepositorio.findOne(categoria.getId())).isNull();
    }
}
