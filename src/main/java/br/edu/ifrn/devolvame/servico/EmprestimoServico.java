package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class EmprestimoServico extends ServicoAbstrato<Emprestimo, Long>{
   
    @Override
    public void save(Emprestimo objeto){
        objeto.verificarUsuario();
        
        super.save(objeto);
    }
    
    @Transactional
    public void emprestar(Usuario donoLivro, Livro livro, Usuario destinatario){
       if (donoLivro.equals(destinatario)){
           throw new IllegalArgumentException
            ("Dono do livro não pode ser o destinatário: " + donoLivro + " = " + destinatario);
       }
       
       Emprestimo emprestimoLivro = Emprestimo.builder()
               .donoLivro(donoLivro)
               .livro(livro)
               .destinatario(destinatario)
               .build();
       save(emprestimoLivro);
    }
}
