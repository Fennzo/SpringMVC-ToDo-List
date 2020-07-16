package com.Alex.Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;



// Used as a static database
@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static int todoCount = 3;


	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("MM/dd/yyyy").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	 static Date d1 = parseDate("01/05/2021");
	 static Date d2 = parseDate("10/06/2020");
	 static Date d3 = parseDate("12/07/2021");
	 
	static {
		todos.add(new ToDo(1, "jyj123", "Learn Spring MVC", d1,
				false));
		todos.add(new ToDo(2, "jyj123", "Learn Struts", d2, false));
		todos.add(new ToDo(3, "jyj123", "Learn Hibernate", d3,
				false));
	}
	
	public void updateToDo(ToDo todo) {
	todos.set(todo.getId()-1, todo);
	}
	
	public ToDo retrieveTodo(int i) {
		return todos.get(i);
	}

	// Loop through each obj in the todos list, if user match argument, add it to the list filteredToDos
	public List<ToDo> retrieveTodos(String user) {
		List<ToDo> filteredTodos = new ArrayList<ToDo>();
		for (ToDo todo : todos) {
		
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	// add new entry to the todos list
	public void addTodo(String name, String description, Date targetDate, boolean isDone) {
		todos.add(new ToDo(++todoCount, name, description, targetDate, isDone));
	}

	// Loop through todos list to find an id that matches in the argument and deletes it
	public void deleteTodo(int id) {
		Iterator<ToDo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			ToDo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}