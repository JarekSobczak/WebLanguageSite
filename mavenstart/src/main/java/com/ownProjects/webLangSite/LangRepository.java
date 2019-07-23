package com.ownProjects.webLangSite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository {
//    private List<Lang>languages;
//    LangRepository(){
//        languages=new ArrayList<>();
//        languages.add(new Lang(1,"Hello","en"));
//        languages.add(new Lang(2,"Witaj","pl"));
//        languages.add(new Lang(3,"Priviet","ru"));
//    }

    Optional<Lang>findById(Integer id){
        var session=HibernateUtil.getSessionFactory().openSession();
        var transaction=session.beginTransaction();
        var result=session.get(Lang.class,id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }
}
