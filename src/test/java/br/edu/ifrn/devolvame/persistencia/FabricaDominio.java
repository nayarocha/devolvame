package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.dominio.Livro;
import br.edu.ifrn.devolvame.dominio.Usuario;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FabricaDominio {
    
    public final static String USER1 = "deadpool@email.com";
    public final static String USER2 = "hulk@email.com";
    public final static String LIVRO1 = "jogos vorazes";
    public final static String LIVRO2 = "Steve jobs";
    public final static String CATEGORIA1 = "biografia";
    public final static String CATEGORIA2 = "ficção";
    public final static String DESCRICAO_ACERVO = "Livros sobre a vida na selva";
    
    
    @Inject
    private AcervoRepositorio acervoRepositorio;
    
    @Inject 
    private AutorRepositorio autorRepositorio;
    
    @Inject
    private CategoriaRepositorio categoriaRepositorio;
    
    @Inject
    private EmprestimoRepositorio emprestimoRepositorio;
    
    @Inject 
    private LivroRepositorio livroRepositorio;
    
    @Inject 
    private UsuarioRepositorio usuarioRepositorio;
    
    
    public Usuario user1(){
        Usuario user1 = Usuario.builder().email(USER1).build();
        usuarioRepositorio.save(user1);
        return user1;
    }
    
    public Acervo acervo(){
        Acervo acrv = Acervo.builder().descricao(DESCRICAO_ACERVO).build();
        acervoRepositorio.save(acrv);
        return acrv;
    }
    
    
    public Usuario user2(){
        Usuario user2 = Usuario.builder().email(USER2).build();
        usuarioRepositorio.save(user2);
        return user2;
    } 
    
    
    public Categoria biografia(){
       Categoria categoria1 = Categoria.builder().nomeCategoria(CATEGORIA1).build();
       categoriaRepositorio.save(categoria1);
       return categoria1;    
    }
    
    public Categoria ficcao(){
       Categoria categoria2 = Categoria.builder().nomeCategoria(CATEGORIA2).build();
       categoriaRepositorio.save(categoria2);
       return categoria2;     
    }
    
    
    public Livro jogosVorazes(){
        Livro livro1 = Livro.builder().titulo(LIVRO1).build();
        livroRepositorio.save(livro1);
        return livro1;
    }
    
    public Livro steveJobs(){
        Livro livro2 = Livro.builder().titulo(LIVRO2).build();
        livroRepositorio.save(livro2);
        return livro2;
    }
     
     
    
    
}
