package com.ownProjects.webLangSite.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "HelloServlet",urlPatterns = "/api")
public class HelloServlet extends HttpServlet {
    private final Logger logger=LoggerFactory.getLogger(HelloServlet.class);
    private static final String NAME_PARAM="name";
    private static final String LANG_PARAM="lang";

    HelloService service;

    /**
     * Server container needs it !
     */
    @SuppressWarnings("unused")
    public HelloServlet(){
        this(new HelloService());
    }
    // powyższy konstruktor bezparametrowy dla działania niejawnego servletu, a poniższy dla nas ..
    HelloServlet(HelloService service){
        this.service=service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Integer langId=null;
        var name=req.getParameter(NAME_PARAM);
        var lang=req.getParameter(LANG_PARAM);
        logger.info("Got request with parameter "+req.getParameterMap());
        try {
            langId= Integer.valueOf(lang);
        }catch (NumberFormatException e){
            logger.warn("Non-numeric value is used: "+ lang);
        }
        resp.getWriter().write(service.prepareGreetings(name,langId));
    }
}
