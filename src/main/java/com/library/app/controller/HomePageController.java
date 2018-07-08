package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.app.model.Book;
import com.library.app.service.BookService;

@Controller
public class HomePageController {
	
	@Autowired 
	private BookService bookService;
	
	@RequestMapping(value="homepage",method=RequestMethod.GET)
	public String homePage(Model model) {
		return "homepage";
	}
}
