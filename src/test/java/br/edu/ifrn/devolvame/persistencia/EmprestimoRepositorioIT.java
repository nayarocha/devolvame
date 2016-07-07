package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
//@Test(groups = "emprestimo")
@Test(dependsOnGroups  = {"livro","usuario"})
public class EmprestimoRepositorioIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private EmprestimoRepositorio emprestimoRepositorio;
    
    @Inject
    private EmprestimoFabrica emprestimoFabrica;
    
    @Inject 
    private LivroFabrica livroFabrica;
    
    @Inject 
    private UsuarioFabrica usuarioFabrica;
    
    
    @BeforeMethod
    void deletarTodos() {
       emprestimoRepositorio.deleteAll();   
        assertThat(emprestimoRepositorio.findAll()).isEmpty();
    }
    
    
    public void emprestimoNaoEnulo(){
        assertThat(emprestimoRepositorio).isNotNull();
    }

    
    public void novoEmprestimo(){
      Livro livro = livroFabrica.jogosVorazes();
      
      Usuario user1 = usuarioFabrica.user1();
      Usuario user2 = usuarioFabrica.user2();
      
      Emprestimo  emprestimo = emprestimoFabrica.emprestimo(user1, user2, livro);
      emprestimoRepositorio.save(emprestimo);
      assertThat(emprestimoRepositorio.findAll().iterator().next()).isEqualTo(emprestimo);
    }    
    
    public void deletarEmprestimo(){
        Livro livro = livroFabrica.jogosVorazes();
      
        Usuario user1 = usuarioFabrica.user1();
        Usuario user2 = usuarioFabrica.user2();
        
        Emprestimo emprestimo = emprestimoFabrica.emprestimo(user1, user2, livro);   
        emprestimoRepositorio.delete(emprestimo);
        assertThat(emprestimoRepositorio.findOne(emprestimo.getId())).isNull();
    }
    
    public void emprestimoLivrosDiferentesMesmoUsuario(){
        Livro steveJobs = livroFabrica.steveJobs();
        Livro jogosVorazes = livroFabrica.jogosVorazes();
        
        //Dono do livro steveJobs
        Usuario adolfo =  usuarioFabrica.adolfo();  
        
        //Dono do livro jogos vorazes
        Usuario pedro = usuarioFabrica.pedro();
        
        //destinatario dos livros
        Usuario nayara = usuarioFabrica.nayara();
       
        Emprestimo livroSteveJobs = emprestimoFabrica.emprestimo(adolfo, nayara, steveJobs);
        Emprestimo livrojogosVorazes = emprestimoFabrica.emprestimo(pedro, nayara, jogosVorazes);
        assertThat(livroSteveJobs).isNotEqualByComparingTo(livrojogosVorazes);
    }
}
