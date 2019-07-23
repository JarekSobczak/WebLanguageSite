package com.ownProjects.webLangSite;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LangServlet", urlPatterns = "/api/langs")
public class LangsServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(LangsServlet.class);


    private LangRepository repository;
    private ObjectMapper mapper;

    /**
     * Server container needs it !
     */
    @SuppressWarnings("unused")
    public LangsServlet() {
        this(new LangRepository(), new ObjectMapper());
    }

    // powyższy konstruktor bezparametrowy dla działania niejawnego servletu, a poniższy dla nas ..
    LangsServlet(LangRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Got request with parameter " + req.getParameterMap());
        mapper.writeValue(resp.getOutputStream(), repository.findAll());
        resp.setContentType("application/json;charset=UTF-8");
        // resp.getWriter().write(service.prepareGreetings(req.getParameter(NAME_PARAM),req.getParameter(LANG_PARAM)));
    }
}
