package com.Alex.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


// Means it applies to all controllers. Use for exception handling / binding
@ControllerAdvice
// Support configuration
@EnableWebMvc
public class ExceptionController {

	// to log
	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error("Request " + request.getRequestURI() + " Throw an Exception ", ex);
		return "error";
	}
}
