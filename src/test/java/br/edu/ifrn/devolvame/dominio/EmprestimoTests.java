package br.edu.ifrn.devolvame.dominio;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author nayarocha
 */
@Test
public class EmprestimoTests {
    
    private static final String livro01 = "livro01";
    private static final String livro02 = "livro02";
    private static final String dono_01 = "dono_01";
    private static final String dono_02 = "dono_02";
    private static final String destinatario_01 = "destinatario_01";
    private static final String destinatario_02 = "destinatario_02";
   
    private Emprestimo emprestimo(Date data, String destinatario,String dono,String livro){
        return Emprestimo.builder()
              .livro(Livro.builder().titulo(livro).build())
              .donoLivro(Usuario.builder().email(dono).build())
              .destinatario(Usuario.builder().email(destinatario).build())
              .data(data).build();
          
    }
    
    
    public void mesmoDonoEDestinariosComLivrosDiferentes(){
        Date hoje = new Date();    
        Emprestimo emprestimoLivro1 = emprestimo(hoje,destinatario_01,dono_01,livro01);
        Emprestimo emprestimoLivro2 = emprestimo (hoje, destinatario_01,dono_01, livro02);
        
        assertThat(emprestimoLivro1).isNotEqualTo(emprestimoLivro2);    
    }
    
    
    public void mesmoLivroDonosEdestinatariosDiferentes(){
        Date hoje = new Date();
        Emprestimo emprestimoLivro1 = emprestimo(hoje,destinatario_01,dono_01,livro01);
        Emprestimo emprestimoLivro2 = emprestimo (hoje,destinatario_02,dono_02, livro01);
        
        assertThat(emprestimoLivro1).isNotEqualTo(emprestimoLivro2);
    }
    
    
    public void compareToemprestimoDoMesmoLivroComDataDiferente(){
       
        Set<Emprestimo> emprestimos = new TreeSet<>();
        
        Emprestimo emprestimo1 = emprestimo(new Date(),destinatario_01,dono_01,livro01);
        Emprestimo emprestimo2 = emprestimo(new Date(),destinatario_01,dono_01,livro01);
        
        emprestimos.add(emprestimo2);
        emprestimos.add(emprestimo1);
        
        assertThat(emprestimos.iterator()).isNotEqualTo(emprestimo1);
    }
    
    
    public void compareToComEmprestimoEntreDonosDiferentes(){
        Date hoje = new Date();
        Set<Emprestimo> emprestimos = new TreeSet<>();
         
        Emprestimo emprestimo1 = emprestimo(hoje,destinatario_01,dono_01,livro01);
        Emprestimo emprestimo2 = emprestimo(hoje,destinatario_02,dono_02,livro01);
        
        emprestimos.add(emprestimo2);
        emprestimos.add(emprestimo1);
        
         assertThat(emprestimos.iterator()).isNotEqualTo(emprestimo1);
    }
    
    
    
    
}
