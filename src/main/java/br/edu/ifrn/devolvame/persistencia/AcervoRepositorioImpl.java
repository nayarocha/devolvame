package br.edu.ifrn.devolvame.persistencia;

import br.edu.ifrn.devolvame.dominio.QAcervo;
import br.edu.ifrn.devolvame.dominio.Acervo;
import br.edu.ifrn.devolvame.dominio.Livro;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AcervoRepositorioImpl {
    private final EntityManager entityManager;

    @Inject
    public AcervoRepositorioImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
   public Set<Acervo> getLivrosDoAcervo(Livro l) {
       QAcervo qAcervo = QAcervo.acervo;
       JPQLQueryFactory factory = new JPAQueryFactory(entityManager);
     
        Set<Acervo> livros = (Set<Acervo>) factory
                .from(qAcervo)
                .where(qAcervo.livros.any().eq(l))
                .fetch();
        return livros;
    }
}