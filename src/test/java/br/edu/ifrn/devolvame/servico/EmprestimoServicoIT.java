package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test
public class EmprestimoServicoIT extends AbstractTestNGSpringContextTests{
     
    @Inject
    private EmprestimoServico emprestimoServico;
    
    public void repositorioIsNotNull () {
        assertThat(emprestimoServico).isNotNull();
    }
    
    public void save () {
        Emprestimo emprestimo = Emprestimo.builder()
                .livro(Livro.builder().titulo("harrypotter").build())
                .donoLivro(Usuario.builder().nome("User01").build())
                .destinatario(Usuario.builder().nome("User02").build())
                .build();
        
        emprestimoServico.save(emprestimo);
        
        assertThat(emprestimoServico.iterator().next()).isEqualTo(emprestimo);
    }
    
    public void delete () {
        Emprestimo emprestimo = Emprestimo.builder()
                .livro(Livro.builder().titulo("harrypotter").build())
                .donoLivro(Usuario.builder().nome("User01").build())
                .destinatario(Usuario.builder().nome("User02").build())
                .build();
        
       emprestimoServico.save(emprestimo);
        
       emprestimoServico.delete(emprestimo);       
       assertThat(emprestimoServico.iterator().next()).isEqualTo(emprestimo);
    }
}
