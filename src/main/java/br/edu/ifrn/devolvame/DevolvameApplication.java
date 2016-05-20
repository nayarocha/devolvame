package br.edu.ifrn.devolvame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DevolvameApplication {

	public static void main(String[] args) {
              new SpringApplicationBuilder()                
                .sources(DevolvameApplication.class)
                .run(args);
		
	}
}