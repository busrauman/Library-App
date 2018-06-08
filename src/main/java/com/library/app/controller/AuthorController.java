package com.library.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.app.model.Author;

@Controller
public class AuthorController {

	
	@ModelAttribute("author")
	public Author prepare(@RequestParam(value="id" , required=false) Long id) {
		Author author =  null;
		if(null != id) {
			
		}
		return author;
	}
	
}
