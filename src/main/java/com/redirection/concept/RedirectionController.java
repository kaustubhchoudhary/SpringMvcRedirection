package com.redirection.concept;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectionController {
	
	@GetMapping(value = {"/"})
	public String openIndexPage() {
		return "index";
	}
	
	// Way 1: Using prefix => "redirect:requestUrl"
	@GetMapping(value = "/openPageOne")
	public String openPageOne() {
		System.out.println("\n Open Page One method");
		return "redirect:openPageTwo";
	}
	
	@GetMapping(value = "/openPageTwo")
	public String openPageTwo() {
		System.out.println("\n Open Page Two method");
		return "page_02";
	}
	
 	@GetMapping(value = "/openFirstWebsite")
	public String openFirstWebsite() {
		System.out.println("\n Open website");
		return "redirect:https://en.wikipedia.org/wiki/Java";
	}
 	
	@RequestMapping(value="/openPageThree")
	public String openPageThree(RedirectAttributes attr) {
		
		System.out.println("\n Open Page Three method");

		attr.addFlashAttribute("data1", "Kaustubh");
		attr.addAttribute("data2", "Java FSD Trainer");
		
		return "redirect:openPageFour";
	}
	
	@RequestMapping(value="/openPageFour")
	public String openPageFour(
			@ModelAttribute("data1") String data1,
			@RequestParam("data2") String data2, Model m) {

		System.out.println("\n Open Page Four method");
		
		System.out.println(data1);
		System.out.println(data2);
	
		m.addAttribute("data1", data1);
		m.addAttribute("data2", data2);
		
		return "page_04";
	} 	

	
	// Way 2: Using class => RedirectView
 	@GetMapping(path = "/openPageFive")
	public RedirectView openPageFive() {
		System.out.println("Inside openPageFive method");

		return new RedirectView("openPageSix");
	}
 	
 	@GetMapping(path = "/openPageSix")
	public String openPageSix() {
		System.out.println("Inside openPageSix method");
		
		return "page_06";
	}
 	
 	@GetMapping(value = "/openSecondWebsite")
	public RedirectView openSecondWebsite() {
		System.out.println("\n Open website");
		
		return new RedirectView("https://www.w3schools.com/js/default.asp");
	}
	
 	@RequestMapping(value="/openPageSeven")
	public RedirectView openPageSeven(RedirectAttributes attr) {
		
		System.out.println("\n Open Page Seven method");

		attr.addFlashAttribute("data1", "Java");
		attr.addAttribute("data2", "Core Java");
		attr.addAttribute("data3", "Advanced Java");
		attr.addAttribute("data4", "Spring");
		
		return new RedirectView("openPageEight");
	}
 	
 	@RequestMapping(value="/openPageEight")
	public String openPageEight(
			@ModelAttribute("data1") String data1,
			@RequestParam("data2") String data2,
			@RequestParam("data3") String data3,
			@RequestParam("data4") String data4,
			Model m) {

		System.out.println("\n Open Page Four method");
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
	
		m.addAttribute("data1", data1);
		m.addAttribute("data2", data2);
		m.addAttribute("data3", data3);
		m.addAttribute("data4", data4);
		
		return "page_08";
	} 
 	
 	
 	// Way 3: Legacy way: Use HttpServletResponse 
 	
/* 	
 	@RequestMapping(path = {"","/","/index.jsp"})
	public void getIndex(HttpServletResponse response) throws IOException {
		System.out.println("Inside getIndex method");
		
		// We can redirect to another handler method
		// response.sendRedirect("home");
		
		// We can redirect to an external website
		response.sendRedirect("https://www.google.com/");
	}
*/


}
