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

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Fabinho do FBI
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
}
