package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Usuario;
import br.edu.ifrn.devolvame.persistencia.UsuarioRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UsuarioServico extends ServicoAbstrato<Long, Usuario, UsuarioRepositorio> {
   
    @Inject
    public UsuarioServico(UsuarioRepositorio repositorio){
      super(repositorio);
    }
}
