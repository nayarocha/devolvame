/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.devolvame.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author adf
 */

@Test
public class AcervoTests {
    private static final String EMAIL = "bruno@gmail.com";
    private static final String NOME = "Bruno";
    private static final String OUTRO_NOME = "Joao";
    private static final String EDITORA = "SARAIVA";
    private static final String outra_editora = "NOBEL";
    private static final String titulo = "The Book is on the Table";
    private static final String outro_titulo = "The Book is on the Tablet";
    Set<Livro> livros, outrosLivros;
    Usuario user, anotherUser;

    /**
     * Os acervos são iguais se a coleção de livros for a mesma
     */
    public void acervosSaoIguais(){
        user = Usuario.builder().email(EMAIL).nome(NOME).build();
        anotherUser = Usuario.builder().email(EMAIL).nome(OUTRO_NOME).build();
        
        livros = new HashSet<>();
        outrosLivros = new HashSet<>();
        
        Livro livro = Livro.builder().titulo(titulo).editora(EDITORA).build();
        livros.add(livro);
        outrosLivros.add(livro);
        
        assertThat(Acervo.builder().idUsuario(user).livros(livros))
                .isEqualTo(Acervo.builder().idUsuario(anotherUser).livros(outrosLivros));
    }
    
    public void acervosSaoDiferentes(){
        
        Livro outroLivro = Livro.builder().titulo(titulo).editora(EDITORA).build();
        outrosLivros.add(outroLivro);
        
         assertThat(Acervo.builder().idUsuario(user).livros(livros))
                .isEqualTo(Acervo.builder().idUsuario(anotherUser).livros(outrosLivros));
    }
    
     
}