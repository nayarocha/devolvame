package br.edu.ifrn.devolvame.servico;

import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.persistencia.AcervoRepositorio;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AcervoServico {

    private AcervoRepositorio repositorio;
    
    @Inject
    public AcervoServico(AcervoRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    public void save(Acervo objeto){
        repositorio.save(objeto);
    }
    
    public void delete(Acervo objeto){
        repositorio.delete(objeto);
    }
    
    public Iterator<Acervo> iterator() {
       return repositorio.iterator();
    }
}
