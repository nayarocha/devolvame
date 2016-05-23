package br.edu.ifrn.devolvame.dominio;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author nayarocha
 */
@Test
public class CategoriaTests {
    private static final String ficcao = "ficcao";
    private static final String romance = "romance";
    private static final String livro1 = "livro1";
    private static final String livro2 = "livro2";
    
    public void categoriaIgualSemLivros(){
        assertThat(Categoria.builder().nomeCategoria(ficcao).build())
                .isEqualTo(Categoria.builder().nomeCategoria(ficcao).build());
    }
    
    
    public void categoriaIgualComLivrosDiferentes(){
        Categoria categoria1 = Categoria.builder().nomeCategoria(ficcao).build();
        
        Set<Livro> livros = new HashSet<>();
        
        livros.add(Livro.builder().titulo(livro1).categoria(categoria1).build());
        livros.add(Livro.builder().titulo(livro2).categoria(categoria1).build());
        categoria1.setLivrosDaCategoria(livros);
        
        Categoria categoria2 = Categoria.builder().nomeCategoria(ficcao).build();
      
        assertThat(categoria1).isEqualTo(categoria2);
        
    }
    
    public void nomesDeCategoriasDiferentes(){
        assertThat(Categoria.builder().nomeCategoria(ficcao).build())
                .isNotEqualTo(Categoria.builder().nomeCategoria(romance).build());
    }
    
}
