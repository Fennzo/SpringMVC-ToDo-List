package com.Alex.Controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

@Controller
public class ToDoController {
	 static Logger logger = Logger.getLogger(ToDoController.class.getName());
	@Autowired
	private ToDoService service;
	

	@RequestMapping(value = "/list-todo", method= RequestMethod.GET)
	// HttpSession allows access to the session
	public String showToDo(ModelMap model,  HttpSession httpSession) {
		String user = (String) httpSession.getAttribute("name");
		System.out.println(service.retrieveTodos(user));
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}
	
	// redirect to update form
	@RequestMapping(value = "/update-todo", method= RequestMethod.GET)
	public String getUpdateForm(ModelMap model, @RequestParam int id) {
	
		// To work with command bean
		model.addAttribute("id", id);
		model.addAttribute("todo", service.retrieveTodo(id-1));
		return "updateToDo";
	}
	
	// @valid checks not null and validations in ToDo class e.g. @size
	@RequestMapping(value = "/update-todo", method= RequestMethod.POST)	
	public String submitUpdate(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		if (result.hasErrors()) {
			// Redirect and pass on the id value
			return "redirect:/update-todo?id=" + todo.getId();
		}
		
		service.updateToDo(todo);
		model.clear();
		return "redirect:/list-todo";
	}
	
	// Will be executed first
	@RequestMapping(value = "/add-todo", method= RequestMethod.GET)
	public String showAddForm(ModelMap model) {
		model.addAttribute("todo", new ToDo());
		return "addToDo";
	}
	

	
	/*
	 * Will be executed after form is submitted
	 * @Valid ToDo - command bean from addToDo.jsp. 
	 * @Valid to validate the information
	 * @BindingResult showcases the result of the validation
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String submitAddForm(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "addToDo";
        }
        String user = (String) httpSession.getAttribute("name");
 
        service.addTodo(user, todo.getDescription(), todo.getTargetDate(), false);
        // Clears the url e.g. name?=jyj123
        model.clear();
        // return to the url which executes the showToDO
        return "redirect:/list-todo";
    }
	
		// delete to do entry
	 @RequestMapping(value = "/delete-todo", method= RequestMethod.GET) 
	 public String deleteToDo(ModelMap model, @RequestParam int id) { 
		 service.deleteTodo(id);
		 model.clear();
		 return "redirect:/list-todo"; }
	 
	 
}
