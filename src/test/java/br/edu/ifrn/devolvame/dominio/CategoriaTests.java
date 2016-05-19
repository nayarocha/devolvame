/*
 * Copyright 2016 nayarocha.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
