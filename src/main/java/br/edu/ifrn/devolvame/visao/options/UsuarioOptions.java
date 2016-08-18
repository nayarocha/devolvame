package br.edu.ifrn.devolvame.visao.options;

import br.edu.ifrn.devolvame.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class UsuarioOptions extends Options<Usuario, Long>{
    
    @Override
    public String label(Usuario e){
        return e.getEmail();
    }
    
    @Override
    protected Object key(Usuario e){
        return e.getId();
    }

    
    
}
