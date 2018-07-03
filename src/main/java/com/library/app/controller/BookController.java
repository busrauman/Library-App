package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.app.customeditor.CustomInputEditor;
import com.library.app.model.Author;
import com.library.app.model.Book;
import com.library.app.model.Publisher;
import com.library.app.service.AuthorService;
import com.library.app.service.BookService;
import com.library.app.service.PublisherService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired 
	private PublisherService publisherService;

	
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new CustomInputEditor());
	}
	
	@ModelAttribute("book")
	public Book prepare(@RequestParam(value = "id", required = false) Long id) {
		Book book = null;
		if (null != id) {
			book = bookService.getBook(id);
		}
		if (null == book) {
			book = new Book();
		}
		return book;
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String createBook(Model model) {
		List<Author> authors = authorService.authors();
		model.addAttribute("authors",authors);
		List<Publisher> publishers = publisherService.findAll();
		model.addAttribute("publishers",publishers);
		return "createBook";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String createBook(@ModelAttribute("book") Book book, Model model, BindingResult result) {
		if (!result.hasErrors()) {
			// save
			bookService.saveOrUpdate(book);
		}
		return "redirect:books";
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public String getBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.getBook(id);
		if (null != book) {
			model.addAttribute("book", book);
		}
		return "book";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Book deleteBook(@PathVariable("id") Long id) {
		Book book = bookService.getBook(id);
		if (null != book) {
			book.setDeleted(true);
			bookService.saveOrUpdate(book);
		}
		return book;
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String getAuthor(Model model) {
		List<Book> books = bookService.books();
		model.addAttribute("books", books);
		return "books";
	}
	
	@RequestMapping(value="/book/search",method=RequestMethod.GET)
	public String getAuthor(@RequestParam("search") String search, Model model) {
		if(null != search && !search.equals("")) {
			List<Book> books = bookService.search(search);
			model.addAttribute("books", books);
		}
		return "homepage";
	}
}
