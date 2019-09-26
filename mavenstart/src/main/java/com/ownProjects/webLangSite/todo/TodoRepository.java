package com.ownProjects.webLangSite.todo;

import com.ownProjects.webLangSite.HibernateUtil;
import com.ownProjects.webLangSite.Lang.Lang;

import java.util.List;
import java.util.Optional;

public class TodoRepository {
   public List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Todo", Todo.class).list();
        transaction.commit();
        session.close();
        return result;
    }

   public Todo toogleTodo(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        Todo result = session.get(Todo.class, id);
        result.setDone(!result.isDone());
        transaction.commit();
        session.close();
        return result;
    }
    public Todo addTodo(Todo newTodo){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
         session.persist(newTodo);
        transaction.commit();
        session.close();
        return newTodo;
    }
}
