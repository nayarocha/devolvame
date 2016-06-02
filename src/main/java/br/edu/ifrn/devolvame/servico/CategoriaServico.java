package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Categoria;
import br.edu.ifrn.devolvame.persistencia.CategoriaRepositorio;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CategoriaServico extends ServicoAbstrato<Long, Categoria, CategoriaRepositorio>{
    
    @Inject
    public CategoriaServico(CategoriaRepositorio repositorio){
        super(repositorio);
    }
}
