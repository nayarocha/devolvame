package br.edu.ifrn.devolvame.visao.options;

import br.edu.ifrn.devolvame.dominio.Categoria;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class CategoriaOptions extends Options<Categoria, Long>{

   @Override
    public String label(Categoria e) {
        return e.getNomeCategoria();
    }
    
    @Override
    protected Object key(Categoria e) {
        return e.getId();
    }
    
}
