package br.edu.ifrn.devolvame.dominio;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Adolfo Melo
 */
@Test
public class AutorTest {
    
    private static final String NOME_DA_AUTORA = "Clarice Lispector";
    private static final String NOME_DE_AUTOR = "Paulo Freire";
    
    public void autoresTemOMesmoNome(){
        
        assertThat(Autor.builder().nome(NOME_DA_AUTORA).build())
            .isEqualTo(Autor.builder().nome(NOME_DA_AUTORA).build());
    }
    public void autoresTemNomesDiferentes(){
        assertThat(Autor.builder().nome(NOME_DA_AUTORA).build())
            .isNotEqualTo(Autor.builder().nome(NOME_DE_AUTOR).build());
    }
    
    public void compareTo(){
        Autor autor = Autor.builder().nome(NOME_DE_AUTOR).build();
        Autor autora = Autor.builder().nome(NOME_DA_AUTORA).build();
        
        assertThat(autor.compareTo(autora)).isGreaterThan(0);
        
    }
}
