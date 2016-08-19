package br.edu.ifrn.devolvame.visao.options;

import br.edu.ifrn.devolvame.dominio.Livro;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class LivroOptions extends Options<Livro, Long>{
    
    @Override
    public String label(Livro e){
        return e.getTitulo();
    }
    
    @Override
    protected Object key(Livro e){
        return e.getId();
    }
}
