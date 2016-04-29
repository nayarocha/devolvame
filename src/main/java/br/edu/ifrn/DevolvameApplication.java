package br.edu.ifrn;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DevolvameApplication implements ApplicationContextAware {
        private ApplicationContext context;
	
        public static void main(String[] args) {
		SpringApplication.run(DevolvameApplication.class, args);
                
        }
                @RequestMapping("/sair")
                public void closeApp(){
                    password("devolva");
                }

                @Override
                public void setApplicationContext(ApplicationContext ac) throws BeansException {
                    context = ac;
                }
                
                @RequestMapping("/teste")
                public String execute() {
                    System.out.println("testando");
                return "Apenas um teste";
                }
                
                public void password(String string){
                  if (string == "devolva")
                      ((ConfigurableWebApplicationContext)this.context).close();
                  else {
                      System.out.println("Senha incorreta");
                  }
                } 
}

