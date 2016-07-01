package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.DevolvameApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
@Test(groups = "emprestimo")
public class EmprestimoServicoIT extends AbstractTestNGSpringContextTests{
    //vou finalizar esse teste após terminar o da persistencia
}
