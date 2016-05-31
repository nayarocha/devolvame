package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Usuario;
import java.util.Iterator;

public interface UsuarioRepositorio {
    
    void save(Usuario objeto);

    void delete(Usuario objeto);
    
    Iterator<Usuario> iterator();
}
