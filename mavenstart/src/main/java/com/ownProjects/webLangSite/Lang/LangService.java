package com.ownProjects.webLangSite.Lang;

import java.util.List;
import java.util.stream.Collectors;

public class LangService {
    LangRepository repository;
    LangService(){
        this(new LangRepository());
    }
    LangService(LangRepository repository){
        this.repository=repository;
    }
    List<LangDTO>findAll(){
        return repository.findAll().stream()
                .map(LangDTO::new)
                .collect(Collectors.toList());
    }
}
