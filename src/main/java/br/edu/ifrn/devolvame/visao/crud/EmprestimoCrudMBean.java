package br.edu.ifrn.devolvame.visao.crud;

import br.edu.ifrn.devolvame.dominio.Emprestimo;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class EmprestimoCrudMBean extends CrudMBean<Emprestimo, Long> {
    @Override
	protected Emprestimo createBean() {
		return Emprestimo.builder().build();
	}
}
