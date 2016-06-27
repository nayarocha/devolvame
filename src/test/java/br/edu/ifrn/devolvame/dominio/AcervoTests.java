package br.edu.ifrn.devolvame.dominio;
import java.util.Set;
import java.util.TreeSet;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Adolfo Melo
 */

@Test
public class AcervoTests {
    private static final String EMAIL = "bruno@gmail.com";
    private static final String NOME = "Bruno";
    private static final String OUTRO_NOME = "Joao";
    private static final String EDITORA = "SARAIVA";
    private static final String OUTRA_EDITORA = "NOBEL";
    private static final String TITULO = "The Book is on the Table";
    private static final String OUTRO_TITULO = "The Book is on the Tablet";
    
    
    Usuario user = Usuario.builder().email(EMAIL).nome(NOME).build();
    Usuario anotherUser = Usuario.builder().email(EMAIL).nome(OUTRO_NOME).build();
    Livro livro = Livro.builder().titulo(TITULO).editora(EDITORA).build();
    Livro outroLivro = Livro.builder().titulo(OUTRO_TITULO).editora(OUTRA_EDITORA).build();
    /*
       Os acervos são iguais se a coleção de livros for a mesma
    */
    public void acervosSaoIguais(){
        
        Set<Livro> livros = new TreeSet<>();
        Set<Livro> outrosLivros = new TreeSet<>();
        
        livros.add(livro);
        outrosLivros.add(livro);
        
        assertThat(Acervo.builder().usuario(user).livros(livros))
                .isNotEqualTo(Acervo.builder().usuario(anotherUser).livros(livros));
    }
    
    public void acervosSaoDiferentes(){
        
        Set<Livro> livros = new TreeSet<>();
        Set<Livro> outrosLivros = new TreeSet<>();
        
        livros.add(livro);
        outrosLivros.add(outroLivro);
        
         assertThat(Acervo.builder().usuario(user).livros(livros))
                .isNotEqualTo(Acervo.builder().usuario(anotherUser).livros(outrosLivros));
    }
    
    public void compareTo(){
        
        Set<Livro> livros = new TreeSet<>();
        Set<Livro> outrosLivros = new TreeSet<>();
        
        livros.add(livro);
        outrosLivros.add(livro);

        Acervo umAcervo = Acervo.builder().usuario(user).livros(livros).build();
        Acervo outroAcervo = Acervo.builder().usuario(user).livros(outrosLivros).build();
        
        // Cada acervo tem 1 livro
        assertThat(umAcervo.compareTo(outroAcervo)).isEqualTo(0);
        
        // adiciona outro livro
        outrosLivros.add(outroLivro);
        outroAcervo.setLivros(outrosLivros);

        
        assertThat(umAcervo.compareTo(outroAcervo)).isEqualTo(-1);
        // esvazia a lista de livros a ser comparada
        outrosLivros.clear();
        outroAcervo.setLivros(outrosLivros);
        
        assertThat(umAcervo.compareTo(outroAcervo)).isEqualTo(1);
        
        
        
    }
    
     
}