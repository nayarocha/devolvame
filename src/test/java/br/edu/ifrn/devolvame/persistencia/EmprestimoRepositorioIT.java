package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.DevolvameApplication;
import br.edu.ifrn.devolvame.dominio.Emprestimo;
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
public class EmprestimoRepositorioIT extends AbstractTestNGSpringContextTests {
    private final  Usuario user = Usuario.builder().nome("Jose").build();
    
    @Inject 
    private EmprestimoRepositorio emprestimoRepositorio;
    
    
    public void isNotNull () {
        assertThat(emprestimoRepositorio).isNotNull();
    }
    
    public void save(){
        Emprestimo emprestimo = Emprestimo.builder().donoLivro(this.user).build();
        emprestimoRepositorio.save(emprestimo);
        
        assertThat(emprestimoRepositorio.iterator().hasNext()).isEqualTo(emprestimo);
    }
    
    
    public void delete(){
        Emprestimo emprestimo = Emprestimo.builder().donoLivro(this.user).build();
        emprestimoRepositorio.save(emprestimo);
        
        emprestimoRepositorio.delete(emprestimo);
        
        assertThat(emprestimoRepositorio.iterator().hasNext()).isFalse();
    }
    
}
