package br.edu.ifrn.devolvame;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

/**
 *
 * @author pesquisa
 */
@Component
@Scope("session")
@Getter @Setter
public class DadosTwitter {
    private Twitter twitter;
    
}
