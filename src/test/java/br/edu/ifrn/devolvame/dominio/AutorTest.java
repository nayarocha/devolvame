package br.edu.ifrn.devolvame.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Adolfo Melo
 */
@Test
public class AutorTest {
    
    private static final String NOME_DO_AUTOR = "Clarice Lispector";
    private static final String OUTRO_NOME_DE_AUTOR = "Paulo Freire";
    
    public void autoresTemOMesmoNome(){
        
        assertThat(Autor.builder().autor(NOME_DO_AUTOR).build())
            .isEqualTo(Autor.builder().autor(NOME_DO_AUTOR).build());
    }
    public void autoresTemNomesDiferentes(){
        assertThat(Autor.builder().autor(NOME_DO_AUTOR).build())
            .isNotEqualTo(Autor.builder().autor(OUTRO_NOME_DE_AUTOR).build());
    }
}
