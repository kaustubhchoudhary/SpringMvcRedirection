package com.redirection.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

// To run this project, make sure in RedirectionController, the control is redirected to home
@Controller
public class SearchController {
	
	@RequestMapping("/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("/do-search")
	public RedirectView doSearch(@RequestParam("search-query") String searchQuery) {
		RedirectView redirectView = new RedirectView();
		String webURL = "https://www.google.com/search?q="+searchQuery;
		redirectView.setUrl(webURL);
		return redirectView;
	}
}
