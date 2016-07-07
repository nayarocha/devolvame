package br.edu.ifrn.devolvame.persistencia;

import javax.inject.Named;
import javax.inject.Inject;
import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import java.util.Date;

@Named
public class EmprestimoFabrica {
    
    //Usuários
    public final static String BATMAN = "Batman";
    public final static String DEADPOOL = "Deadpool";
    
    //livros 
    public final static String STEVEJOBS = "Steve jobs";
    public final static String JOGOSVORAZES = "Jogos Vorazes";
    
    @Inject 
    private EmprestimoRepositorio emprestimoRepositorio;
    
    public Emprestimo emprestimo(Usuario donoLivro, Usuario destinatarioLivro, Livro livro){
       Emprestimo emprestimo = Emprestimo.builder()
               .donoLivro(donoLivro)
               .destinatario(destinatarioLivro)
               .livro(livro)
               .data(new Date())
               .build();
       emprestimoRepositorio.save(emprestimo);
       return emprestimo;
    }
  
    
}
