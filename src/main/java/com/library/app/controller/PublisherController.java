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

import com.library.app.model.Publisher;
import com.library.app.service.PublisherService;

@Controller
public class PublisherController {
	@Autowired
	private PublisherService publisherService;
	
	@ModelAttribute("publisher")
	public Publisher prepare(@RequestParam(value="id",required=true) Long id) {
		Publisher publisher = null;
		if(null != id) {
			publisher = publisherService.getPublisher(id);
		}
		if(null == publisher) {
			publisher = new Publisher();
		}
		return publisher;
		
	}
	@RequestMapping(value="/create/publisher",method=RequestMethod.GET)
	public String createPublisher() {
		return "publisher";
	}
	

	@RequestMapping(value="/create/publisher",method=RequestMethod.POST)
	public String createPublisher(@ModelAttribute("publisher") Publisher publisher,BindingResult result) {
		if(!result.hasErrors()) {
			
		}
		return "publisher";
	}

	
	@RequestMapping(value="/publishers",method=RequestMethod.GET)
	public String publishers(Model model) {
		List<Publisher> publishers = publisherService.findAll();
		model.addAttribute("publishers",publishers);
		return "publishers";
	}
	
	@RequestMapping(value="/publisher/{id}",method=RequestMethod.GET)
	public String publisher(@PathVariable("id") Long id,Model model) {
		Publisher publisher = publisherService.getPublisher(id);
		model.addAttribute("publisher",publisher);
		return "publisher";
	}
}
