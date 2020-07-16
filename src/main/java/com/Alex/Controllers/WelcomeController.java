package com.Alex.Controllers;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// Mark this as a controller to handle web requests
@Controller
public class WelcomeController {

	
	/*
	 * After login it goes to / 
	 * Principal to retrieve the name from login page
	 * HttpSession allows variable to be stores in sessions that can be used globally
	 */
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String welcomPage(ModelMap model, HttpSession httpSession, Principal principal) {	
		httpSession.setAttribute("name", principal.getName());
		String name = (String) httpSession.getAttribute("name");
		model.addAttribute("name", name);
		return "welcome";
	}
	
	@RequestMapping(value ="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// get the auth itself
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ( auth != null) {
			// terminate the authentication
			new SecurityContextLogoutHandler().logout(request, response, auth);
			// Delete the session
			request.getSession().invalidate();
		}
		
		
		return "redirect:/";
	}
	
	
}
