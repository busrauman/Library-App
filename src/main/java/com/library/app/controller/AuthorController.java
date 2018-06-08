package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.app.model.Author;
import com.library.app.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@ModelAttribute("author")
	public Author prepare(@RequestParam(value = "id", required = false) Long id) {
		Author author = null;
		if (null != id) {
			author = authorService.getAuthor(id);
		}
		if (null == author) {
			author = new Author();
		}
		return author;
	}
	
	@RequestMapping(value="/create/author",method=RequestMethod.GET)
	public String createAuthor() {
		return "createAuthor";
	}

	@RequestMapping(value="/create/author",method=RequestMethod.POST)
	public String createAuthor(@ModelAttribute("author") Author author, Model model, BindingResult result) {
		if (!result.hasErrors()) {
			//save
			authorService.saveOrUpdate(author);
		}
		return "redirect:authors";
	}

	@RequestMapping(value="/author/{id}",method=RequestMethod.GET)
	public String getAuthor(@PathVariable("id") Long id, Model model) {
		Author author = authorService.getAuthor(id);
		if(null != author) {
			model.addAttribute("author",author);
		}
		return "author";
	}
	
	@RequestMapping(value="/author/delete/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Author getAuthor(@PathVariable("id") Long id) {
		Author author = authorService.getAuthor(id);
		if(null != author) {
			author.setDeleted(true);
			authorService.saveOrUpdate(author);
		}
		return author;
	}
	
	@RequestMapping(value="/authors",method=RequestMethod.GET)
	public String getAuthor(Model model) {
		List<Author> authors = authorService.authors();
		model.addAttribute("authors", authors);
		return "authors";
	}
	
}
