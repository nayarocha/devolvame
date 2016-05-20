/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.devolvame.dominio;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author adf
 */
public class AutorTest {
    
    private final String NOME_DO_AUTOR = "CLarice Lispector";
    private final String OUTRO_NOME_DE_AUTOR = "Paulo Freire";
    
    
    public void autoresTemOMesmoNome(){
        
        assertThat(Autor.builder().autor(NOME_DO_AUTOR))
            .isEqualTo(Autor.builder().autor(NOME_DO_AUTOR));
    }
    public void autoresTemNomesDiferentes(){
        assertThat(Autor.builder().autor(NOME_DO_AUTOR))
            .isEqualTo(Autor.builder().autor(OUTRO_NOME_DE_AUTOR));
    }
}
