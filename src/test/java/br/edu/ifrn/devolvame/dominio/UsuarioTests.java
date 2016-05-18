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



import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Fabinho do FBI
 */
@Test
public class UsuarioTests {

    private static final String EMAIL = "email@a.com";
    private static final String OUTRO_EMAIL = "email@b.com";
    private static final String NOME1 = "nome1";
    private static final String NOME2 = "nome2";
    
    /**
     * 
     */
    public void equalAndHashCodeComEmailIgual(){

        assertThat(Usuario.builder().email(EMAIL).nome(NOME1).build())
            .isEqualTo(Usuario.builder().email(EMAIL).nome(NOME2).build());
    }
    
    public void equalsAndHashCdeComEmailsDiferentes(){
        assertThat(Usuario.builder().email(EMAIL).nome(NOME1).build())
            .isNotEqualTo(Usuario.builder().email(OUTRO_EMAIL).nome(NOME1).build());

    }
    /*
    public void compareTo(){
        Set<Usuario> usuarios = new TreeSet<>();
        
        Usuario user1 = Usuario.builder().nome(NOME1).build();
        usuarios.add(user1);
        Usuario user2 = Usuario.builder().nome(NOME2).build();
        usuarios.add(user2);
        
        assertThat(usuarios.iterator().next()).isEqualTo(user2);
    }*/
}
    