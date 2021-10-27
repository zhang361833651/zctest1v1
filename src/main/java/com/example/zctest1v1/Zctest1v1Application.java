package com.example.zctest1v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
@SpringBootApplication
@RestController
public class Zctest1v1Application {

    public static void main(String[] args) {
        SpringApplication.run(Zctest1v1Application.class, args);
    }

    @Configuration
    public class RestTemplateConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/zctest1", method = RequestMethod.GET, produces = "application/json")
    public String  zctest1(@RequestParam(defaultValue = "zctest1v1") String name) {
        return String.format(getDate1() + name + " Hello ！\n"+ restTemplate.getForObject("http://zctest2v1/zctest2", String.class));
    }
//    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
//    public String  test(@RequestParam(defaultValue = "test") String name) {
//        return String.format(restTemplate.getForObject("http://zctest2v1/getdate2", String.class));
//    }

    @GetMapping("/getdate1")
    public  String getDate1(){
        Date date = new Date() ;
        return String.format("zctest1v1---------" + date.toString() + "---------" + "\n");
    }

    @GetMapping("/failback")
    public String failback(){
        return "failback---------error----------";
    }

}
