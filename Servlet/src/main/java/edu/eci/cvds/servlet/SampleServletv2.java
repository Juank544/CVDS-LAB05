package edu.eci.cvds.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
	    urlPatterns = "/SampleServletv2"
	)

public class SampleServletv2 extends HttpServlet{
	private static final long serialVersionUID = 35L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id; Todo todo; String name;
        Writer writer = resp.getWriter();
        
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        ArrayList<Todo> todoList = new ArrayList<Todo>();

        try{
            if(optName.isPresent()){
                resp.setStatus(HttpServletResponse.SC_OK);
                name = optName.get();
                id = Integer.parseInt(name);
                
                todo = Service.getTodo(id);
                todoList.add(todo);
                writer.write(Service.todosToHTMLTable(todoList));
            }
        }
        catch(FileNotFoundException excep){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        catch(MalformedURLException m){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.write("error interno en el servidor");
        }
        catch(NumberFormatException n){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.write("requerimiento inválido");
        }
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id; Todo todo; String name;
        Writer writer = resp.getWriter();
        
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        ArrayList<Todo> todoList = new ArrayList<Todo>();

        try{
            if(optName.isPresent()){
                resp.setStatus(HttpServletResponse.SC_OK);
                name = optName.get();
                id = Integer.parseInt(name);
                
                todo = Service.getTodo(id);
                todoList.add(todo);
                writer.write(Service.todosToHTMLTable(todoList));
            }
        }
        catch(FileNotFoundException excep){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        catch(MalformedURLException m){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.write("error interno en el servidor");
        }
        catch(NumberFormatException n){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.write("requerimiento inválido");
        }
    }

}