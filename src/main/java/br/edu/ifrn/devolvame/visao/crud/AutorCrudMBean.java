package br.edu.ifrn.devolvame.visao.crud;

import br.edu.ifrn.devolvame.dominio.Autor;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


@ViewScoped
@Named
public class AutorCrudMBean extends CrudMBean<Autor, Long> {
    
	@Override
	protected Autor createBean() {
		return Autor.builder().build();
	}
}
