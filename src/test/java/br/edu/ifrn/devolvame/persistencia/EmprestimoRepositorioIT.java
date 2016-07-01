package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import java.util.Date;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "emprestimo")
public class EmprestimoRepositorioIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private EmprestimoRepositorio emprestimoRepositorio;
    
    @Inject
    private EmprestimoFabrica emprestimoFabrica;
    
    @Inject 
    private LivroFabrica livroFabrica;
    
    
    @BeforeMethod
    void deletarTodos() {
       emprestimoRepositorio.deleteAll();   
        assertThat(emprestimoRepositorio.findAll()).isEmpty();
    }
    
    
    public void emprestimoNaoEnulo(){
        assertThat(emprestimoRepositorio).isNotNull();
    }

    
    /*public void novoEmprestimo(){
      //Criar 2 usuários: donoLivro e destinatario quando tiver UsuarioFabrica
      Date data = new Date();
      Livro livro = livroFabrica.jogosVorazes();
      
      //emprestimoFabrica.emprestimo("Batman", "Robin", livro);    
    }*/
}
