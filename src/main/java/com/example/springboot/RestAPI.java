/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot;



import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author xiangzhihua
 */
@RestController
public class RestAPI  {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
//    Logger logger = LoggerFactory.getLogger(getClass());
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
            System.out.println("****out test *****");
            LOGGER.debug(" ***  restapi greeting **");
        
         
            Greeting retGreeting=new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
            
            LOGGER.debug("This is a debug message:"+name);
            LOGGER.info("This is an info message:"+name);
            if(name.equals("bad")){
                LOGGER.warn("This is a warn message: "+name);
                LOGGER.error("This is an error message: "+name);    
            }
            LOGGER.info("return msg:"+retGreeting.toString());
            
        return retGreeting ;
    }
    
    @RequestMapping("/")
    public String defalut(@RequestParam(value="name", defaultValue="World") String name) {
        
            System.out.println("****out test *****");
            LOGGER.debug(" ***  restapi greeting **");
        
            LOGGER.debug("This is a debug message");
            LOGGER.info("This is an info message");
            
            
            String msg="Thist is springboot test \n ";
            LOGGER.info("return msg:"+ msg); 
        return msg ;
    }
    
   
    
 
    
}

