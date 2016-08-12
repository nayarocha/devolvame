package br.edu.ifrn.devolvame.visao.crud;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Usuario;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class AcervoCrudMBean extends CrudMBean<Acervo, Long> {
    
	@Override
	protected Acervo createBean() {
		return Acervo.builder()
                       .usuario(Usuario.builder().id(Long.MIN_VALUE).build())
                        
                        .build();
	}
        
      
}
