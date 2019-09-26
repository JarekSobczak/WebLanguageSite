package com.ownProjects.webLangSite.Hello;

import com.ownProjects.webLangSite.Lang.Lang;
import com.ownProjects.webLangSite.Lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
     static final String DEFAULT_NAME="World";
     static final Lang DEFAULT_LANG=new Lang(1,"Hello","en");
    private final Logger logger= LoggerFactory.getLogger(HelloService.class);
     private LangRepository repository;

     HelloService(){
         this(new LangRepository());
     }

    public HelloService(LangRepository repository) {
         this.repository=repository;
    }

     String prepareGreetings(String name, Integer langId){
       langId=Optional.ofNullable(langId).orElse(DEFAULT_LANG.getId());
         var message=repository.findById(langId).orElse(DEFAULT_LANG).getMessage();
        return message+" "+Optional.ofNullable(name).orElse(DEFAULT_NAME)+" !";
     }
}
