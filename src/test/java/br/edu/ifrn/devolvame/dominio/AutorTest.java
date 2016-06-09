package br.edu.ifrn.devolvame.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
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
        
        assertThat(Autor.builder().autor(NOME_DA_AUTORA).build())
            .isEqualTo(Autor.builder().autor(NOME_DA_AUTORA).build());
    }
    public void autoresTemNomesDiferentes(){
        assertThat(Autor.builder().autor(NOME_DA_AUTORA).build())
            .isNotEqualTo(Autor.builder().autor(NOME_DE_AUTOR).build());
    }
    
    public void compareTo(){
        Autor autor = Autor.builder().autor(NOME_DE_AUTOR).build();
        Autor autora = Autor.builder().autor(NOME_DA_AUTORA).build();
        
        assertThat(autor.compareTo(autora)).isGreaterThan(0);
        
    }
}
