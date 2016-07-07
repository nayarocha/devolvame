package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Autor;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import static br.edu.ifrn.devolvame.persistencia.AutorFabrica.AUTOR1;
import static br.edu.ifrn.devolvame.persistencia.AutorFabrica.AUTOR2;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "autor")
public class AutorRepositorioIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    AutorRepositorio autorRepositorio;
    
    @Inject 
    AutorFabrica autorFabrica;
    
    @BeforeMethod
    void deletarTodos(){
        autorRepositorio.deleteAll();
        assertThat(autorRepositorio.findAll()).isEmpty();
    }
    
    public void findByNome(){
        Autor autor1 = autorFabrica.autor1();
        Autor autor2 = autorFabrica.autor2();
        
        assertThat(autorRepositorio.findByNome(AUTOR1)).isEqualTo(autor1);
        assertThat(autorRepositorio.findByNome(AUTOR2)).isEqualTo(autor2);
    }
    
    public void deleteByNome(){
        autorFabrica.autor1();
        autorRepositorio.deleteByNome(AUTOR1);
        assertThat(autorRepositorio.findAll()).isEmpty();
    }
}
