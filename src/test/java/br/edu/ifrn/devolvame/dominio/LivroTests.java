package br.edu.ifrn.devolvame.dominio;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Pedro Rafael
 */

@Test
public class LivroTests {
    private static final String editora = "SARAIVA";
    private static final String outra_editora = "NOBEL";
    private static final String titulo = "The Book is on the Table";
    private static final String outro_titulo = "The Book is on the Tablet";
    
    public void tituloIgualEditoraDiferente(){
        assertThat(Livro.builder().titulo(titulo).editora(editora).build())
                .isEqualTo(Livro.builder().titulo(titulo).editora(outra_editora).build());
    }
    
    public void tituloDiferenteComEditoraIgual(){
        assertThat(Livro.builder().titulo(titulo).editora(editora).build())
                .isNotEqualTo(Livro.builder().titulo(outro_titulo).editora(editora).build());
    }
       
    public void CompareTo(){
        Set<Livro> livros = new TreeSet<>();
        Livro livro2 = Livro.builder().titulo(titulo).build();
        livros.add(livro2);
        Livro livro1 = Livro.builder().titulo(outro_titulo).build();
        livros.add(livro1);
        
        assertThat(livros.iterator().next()).isEqualTo(livro2);
    }
}
