package com.Alex.Controllers;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class ToDo {

	int id;
	String user;
	
	// Validation
	@Size(min = 6, message = "Enter at least 6 characters")
	String description;
	boolean completion;
	
	// @@FutureO ensures the date is the future
	// @DateTimeFormat sets the format of the date
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date targetDate;
	
	/*
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	 * date= sdf.format(new Date());
	 */
	
	public ToDo(int id, String user, String description, Date targetDate, boolean completion) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.completion = completion;
		this.targetDate = targetDate;
	}
	
	public ToDo() {
		
	}

	// Getters and setters are used in JSP
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return completion;
	}
	public void setDone(boolean isDone) {
		this.completion = isDone;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}


	public boolean isCompletion() {
		return completion;
	}


	public void setCompletion(boolean completion) {
		this.completion = completion;
	}


	public Date getTargetDate() {
		return targetDate;
	}


	@Override
	public String toString() {
		return "ToDo [id=" + id + ", user=" + user + ", description=" + description + ", isDone=" + completion
				+ ", targetDate=" + targetDate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (completion ? 1231 : 1237);
		result = prime * result + ((targetDate == null) ? 0 : targetDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (completion != other.completion)
			return false;
		if (targetDate == null) {
			if (other.targetDate != null)
				return false;
		} else if (!targetDate.equals(other.targetDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	
	
}
