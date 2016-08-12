package br.edu.ifrn.devolvame.visao.crud;

import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.dominio.Livro;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class LivroCrudMBean extends CrudMBean<Livro, Long>{
    @Override
	protected Livro createBean() {
            return Livro.builder()
                .categoria(Categoria.builder().build())
                .build();
	}
}
