package br.edu.ifrn.devolvame;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    private Facebook facebook;
	private ConnectionRepository connectionRepository;
       
    @Inject
    public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloFacebook(Model model, HttpServletRequest request) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile()); 
        //model.addAttribute("userID", facebook.userOperations().getUserProfile().getId());
    
        HttpSession session = request.getSession();
        HttpSession nome = request.getSession();
        session.setAttribute("userID", facebook.userOperations().getUserProfile().getId());
        nome.setAttribute("nome", facebook.userOperations().getUserProfile().getName());
        return "redirect:livro.jsf";
    }
}
