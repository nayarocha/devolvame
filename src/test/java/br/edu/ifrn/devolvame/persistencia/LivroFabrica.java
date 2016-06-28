package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Autor;
import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.dominio.Livro;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LivroFabrica {
    public final static String STEVEJOBS = "Steve jobs";
    public final static String JOGOSVORAZES = "Jogos Vorazes";
    public final static String DESCRICAO = "Descricao livro 01";
    public final static int DISPONIVEL = 0;
    public final static int EMPRESTADO = 1;
    public final static String BATMAN = "Batman";
    public final static String DEADPOOL = "Deadpool";
    
    
    @Inject 
    private LivroRepositorio livroRepositorio;
    
    
   public Livro livro(String titulo){
        Livro livro = Livro.builder()           
                .titulo(titulo)
                .build();
        livroRepositorio.save(livro);
        return livro;
    }
        
   public Livro livro(Long id,String titulo, int isbn, String editora, String descricao, Categoria categoria, int status){
        Livro livro = Livro.builder()
                .id(Long.MIN_VALUE)
                .titulo(titulo)
                .isbn(isbn)
                .editora(editora)
                .descricao(descricao)
                .categoria(categoria)
                .status(0)
                .build();
        livroRepositorio.save(livro);
        return livro;
    }
   
   public Livro livro(String titulo, int isbn, String editora, String descricao, Categoria categoria, int status){
        Livro livro = Livro.builder()
                .titulo(titulo)
                .isbn(isbn)
                .editora(editora)
                .descricao(descricao)
                .categoria(categoria)
                .status(0)
                .build();
        livroRepositorio.save(livro);
        return livro;
    }
    
    
    public Livro livroStatus(int status){
        Livro livro = livroRepositorio.findByStatus(status);
        if (livro == null){
            livro = Livro.builder()
                    .status(status)
                    .build();
            livroRepositorio.save(livro);
        }
        return livro;
    }
    
    
     public Livro livroTitle(String titulo){
        Livro livro = livroRepositorio.findByTitulo(titulo);
        if (livro == null){
            livro = Livro.builder()
                    .titulo(titulo)
                    .build();
            livroRepositorio.save(livro);
        }
        return livro;
    }
    
    
    public int disponivel(){
        return (DISPONIVEL);
    }
 
    public int emprestado(){
        return(EMPRESTADO);
    }
    
  
   public Livro steveJobs(){
       return livro(STEVEJOBS);
   }
   
    public Livro jogosVorazes(){
       return livro(JOGOSVORAZES);
   }
}
