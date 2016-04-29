/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@RestController
class ShutdownController {

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping("/sair")
    public void initiateShutdown(){
        ((ConfigurableApplicationContext)appContext).close();
    }
}