package br.edu.ifrn.devolvame.persistencia;


import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioFabrica {
    public final static String USER1 = "pedrorafael0251@gmail.com";
    public final static String USER2 = "nayarocha@gmail.com";
   
     
    @Inject 
    private UsuarioRepositorio usuarioRepositorio;
    
    private Usuario usuario(String emailUsuario){
        Usuario usuario = usuarioRepositorio.findByEmailUsuario(emailUsuario);
        if (usuario == null){
            usuario = Usuario.builder().email(emailUsuario).build();
            usuarioRepositorio.save(usuario);
        }
        
        return usuario;
    }
    
    public Usuario user1(){
        return usuario(USER1);
    }
    
    public Usuario user2(){
        return usuario(USER2);
    }
}
