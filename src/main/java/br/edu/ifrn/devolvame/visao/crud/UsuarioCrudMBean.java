package br.edu.ifrn.devolvame.visao.crud;

import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

//@ViewScoped
@SessionScoped
@Named
public class UsuarioCrudMBean extends CrudMBean<Usuario, Long> {
        @Override
	protected Usuario createBean() {
		return Usuario.builder().build();
	}    
}
