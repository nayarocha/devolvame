package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.persistencia.LivroFabrica;
import br.edu.ifrn.devolvame.persistencia.UsuarioFabrica;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "emprestimo", dependsOnGroups = {"livro", "usuario"})
public class EmprestimoServicoIT extends AbstractTestNGSpringContextTests{

@Inject private UsuarioFabrica usuarioFabrica;

@Inject private LivroFabrica livroFabrica;

@Inject private EmprestimoServico emprestimoServico;

@Test(expectedExceptions = IllegalArgumentException.class)
 public void novoEmprestimo(){

     Emprestimo emprestimo = 
            Emprestimo.builder()
                       .donoLivro(usuarioFabrica.nayara())
                       .livro(livroFabrica.jogosVorazes())
                       .destinatario(usuarioFabrica.pedro())
                       .build();
            emprestimoServico.save(emprestimo);
 }  
}
