package com.ownProjects.webLangSite;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Lang {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private Integer id;
    private String message, code;

    /**
     *  Hibernate (JPA) uses it !
     */
    @SuppressWarnings("unused")
    public Lang(){

    }

     public Lang(Integer id, String message, String code) {
         this.id = id;
         this.message = message;
         this.code = code;
     }

     public Integer getId() {
         return id;
     }

     public String getMessage() {
         return message;
     }

     public String getCode() {
         return code;
     }

     public void setMessage(String message) {
         this.message = message;
     }

     public void setCode(String code) {
         this.code = code;
     }
 }
