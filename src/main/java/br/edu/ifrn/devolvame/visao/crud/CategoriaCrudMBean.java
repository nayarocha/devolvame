package br.edu.ifrn.devolvame.visao.crud;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.edu.ifrn.devolvame.dominio.Categoria;

@ViewScoped
@Named
public class CategoriaCrudMBean extends CrudMBean<Categoria, Long> {

	@Override
	protected Categoria createBean() {
		return Categoria.builder().build();
	}

}