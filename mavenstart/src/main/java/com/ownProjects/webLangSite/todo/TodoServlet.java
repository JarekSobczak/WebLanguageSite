package com.ownProjects.webLangSite.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ownProjects.webLangSite.Lang.LangService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoServlet", urlPatterns = "/api/todos/*")
public class TodoServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);


    private TodoRepository repository;
    private ObjectMapper mapper;

    /**
     * Server container needs it !
     */
    @SuppressWarnings("unused")
    public TodoServlet() {
        this(new TodoRepository(), new ObjectMapper());
    }

    // powyższy konstruktor bezparametrowy dla działania niejawnego servletu, a poniższy dla nas ..
    TodoServlet(TodoRepository repository, ObjectMapper mapper) {
        this.repository= repository;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Got request with parameter " + req.getParameterMap());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), repository.findAll());

        // resp.getWriter().write(service.prepareGreetings(req.getParameter(NAME_PARAM),req.getParameter(LANG_PARAM)));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        var pathInfo=req.getPathInfo();
        logger.info("path : "+pathInfo);
        try {
            var todoId= Integer.valueOf(pathInfo.substring(1));
            var todo=repository.toogleTodo(todoId);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), todo);
        }catch (NumberFormatException e){
            logger.warn("Wrong path: "+ pathInfo);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Todo newTodo = mapper.readValue(req.getInputStream(),Todo.class);
       mapper.writeValue(resp.getOutputStream(), repository.addTodo(newTodo));

    }
}
