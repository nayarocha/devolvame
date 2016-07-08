package br.edu.ifrn.devolvame.persistencia;


import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioFabrica {
    public final static String USER1 = "pedrorafael0251@gmail.com";
    public final static String USER2 = "nayarocha@gmail.com";
    public final static String USER3 = "adolfo@gmail.com";
    
    public final static String ADOLFO = "adolfo";
    public final static String NAYARA = "Nayara";
    public final static String PEDRO =  "Pedro"; 
   
     
    @Inject 
    private UsuarioRepositorio usuarioRepositorio;
    
    private Usuario usuario(String nome,String emailUsuario, String senha){
        Usuario usuario = usuarioRepositorio.findByEmail(emailUsuario);
        if (usuario == null){
            usuario = Usuario.builder()
                    .nome(nome)
                    .email(emailUsuario)
                    .senha(senha)
                    .build();
            usuarioRepositorio.save(usuario);
        }
        
        return usuario;
    }
    
    public Usuario pedro(){
        return usuario(PEDRO, USER1,"123456");
    }
    
     public Usuario nayara(){
        return usuario(NAYARA, USER2,"123456");
    }
    
    public Usuario adolfo(){
        return usuario(ADOLFO, USER3,"123456");
    }
    
}
