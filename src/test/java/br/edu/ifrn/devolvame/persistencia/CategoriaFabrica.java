package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.Categoria;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CategoriaFabrica {

public final static String ROMANCE = "Romance";
public final static String BIOGRAFIA = "Biografia";

@Inject
private CategoriaRepositorio categoriaRepositorio;

private Categoria categoria(String nomeCategoria) {
   Categoria categoria = categoriaRepositorio.findByNomeCategoria(nomeCategoria);
   if (categoria == null) {
       categoria = Categoria.builder().nomeCategoria(nomeCategoria).build();
       categoriaRepositorio.save(categoria);
   }
   return categoria;
}

public Categoria romance(){
    return categoria(ROMANCE);
}

public Categoria biografia(){
    return categoria(BIOGRAFIA);
}
}
