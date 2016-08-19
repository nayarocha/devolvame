package br.edu.ifrn.devolvame;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/logintwitter")
public class TwitterController {
     private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model,HttpServletRequest request) {
        if (connectionRepository.findPrimaryConnection(Twitter.class)  == null) {
            return "redirect:/connect/twitter";
        }
        
        
        model.addAttribute("twitterProfile", twitter.userOperations().getUserProfile());
        //model.addAttribute(twitter.userOperations().getUserProfile());
        
        HttpSession session = request.getSession();
        HttpSession nome = request.getSession();
        session.setAttribute("imgProfile", twitter.userOperations().getUserProfile().getProfileImageUrl());
        nome.setAttribute("nometwitter", twitter.userOperations().getUserProfile().getName());
       
        return "redirect:usuario.jsf";
    }
    
}
