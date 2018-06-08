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
import com.library.app.model.Book;
import com.library.app.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

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

	@RequestMapping(value = "/create/book", method = RequestMethod.GET)
	public String createBook() {
		return "createBook";
	}

	@RequestMapping(value = "/create/book", method = RequestMethod.POST)
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

	@RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
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
}
