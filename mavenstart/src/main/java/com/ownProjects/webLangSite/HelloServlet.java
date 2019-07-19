package com.ownProjects.webLangSite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "HelloServer",urlPatterns = "/api/*")
public class HelloServlet extends HttpServlet {
    private final Logger logger=LoggerFactory.getLogger(HelloServlet.class);
    private static final String NAME_PARAM="name";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request with parameter "+req.getParameterMap());
        var name= Optional.ofNullable(req.getParameter(NAME_PARAM)).orElse("World !!!");
        resp.getWriter().write("Hello "+name+" !");
    }
}
