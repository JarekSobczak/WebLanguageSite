package com.ownProjects.webLangSite;

 class Lang {
    private Long id;
    private String message, code;

     public Lang(Long id, String message, String code) {
         this.id = id;
         this.message = message;
         this.code = code;
     }

     public Long getId() {
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
