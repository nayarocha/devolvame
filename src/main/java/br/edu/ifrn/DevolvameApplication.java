package br.edu.ifrn;

import javax.servlet.ServletContext;
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
                    ((ConfigurableWebApplicationContext)this.context).close();
                }

                @Override
                public void setApplicationContext(ApplicationContext ac) throws BeansException {
                    context = ac;
                }
}

