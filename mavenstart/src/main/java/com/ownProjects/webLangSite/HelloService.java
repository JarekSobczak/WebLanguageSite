package com.ownProjects.webLangSite;

import java.util.Optional;

class HelloService {
     static final String DEFAULT_NAME="World";

     String prepareGreetings(String name){
        return Optional.ofNullable("Hello "+name).orElse(DEFAULT_NAME)+" !";
     }
}
