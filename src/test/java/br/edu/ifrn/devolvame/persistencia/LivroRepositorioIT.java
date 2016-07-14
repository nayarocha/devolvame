package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.dominio.Livro;
import static br.edu.ifrn.devolvame.persistencia.LivroFabrica.DISPONIVEL;
import static br.edu.ifrn.devolvame.persistencia.LivroFabrica.EMPRESTADO;
import static br.edu.ifrn.devolvame.persistencia.LivroFabrica.JOGOSVORAZES;
import static br.edu.ifrn.devolvame.persistencia.LivroFabrica.STEVEJOBS;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
//@Test(groups = "livro", dependsOnGroups  = {"categoria"})
@Test(groups = "livro")
public class LivroRepositorioIT extends AbstractTestNGSpringContextTests {

    @Inject
    private LivroRepositorio livroRepositorio;

    @Inject
    private LivroFabrica livroFabrica;

    @Inject
    private CategoriaFabrica categoriaFabrica;

    @BeforeMethod
    void deletarTodos() {
        livroRepositorio.deleteAll();
        
        assertThat(livroRepositorio.findAll()).isEmpty();
    }

    public void verificaPorStatus(){
        int disponivel  = livroFabrica.disponivel();
        int emprestado  = livroFabrica.emprestado();
        
        assertThat(livroRepositorio.findByStatus(disponivel)).isNotEqualTo(emprestado);   
    }
    
    //verifica livros de id's e status diferentes
    public void tituloIguais() {
        Categoria categoria = categoriaFabrica.biografia();
        Livro livro = livroFabrica.livro(0L ,STEVEJOBS, 1334, "editora Teste", "historia do steve", categoria, DISPONIVEL);        
        
        assertThat(livroFabrica.livro(1L, STEVEJOBS, 1334, "editora Teste", "historia do steve", categoria, EMPRESTADO)).isEqualTo(livro);
    }
    
    public void findByTitulo(){
        Livro steveJobs = livroFabrica.steveJobs();
        Livro jogosVorazes = livroFabrica.jogosVorazes();
        
        assertThat(livroRepositorio.findByTitulo(STEVEJOBS)).isEqualTo(steveJobs);
        assertThat(livroRepositorio.findByTitulo(JOGOSVORAZES)).isEqualTo(jogosVorazes);
    }
    
    
   public void salvarLivro(){
      Categoria categoria = categoriaFabrica.biografia();
      Livro livro = livroFabrica.livro("Steve jobs", 1334, "editora Teste", "historia do steve", categoria, 0);  
      livroRepositorio.save(livro);
      
      assertThat(livroRepositorio.findAll().iterator().next()).isEqualTo(livro);
    }
   
   
   public void deletarLivro(){
       Livro livro = livroFabrica.steveJobs();
       livroRepositorio.delete(livro);
       
       assertThat(livroRepositorio.findOne(livro.getId())).isNull();
   }
} 
