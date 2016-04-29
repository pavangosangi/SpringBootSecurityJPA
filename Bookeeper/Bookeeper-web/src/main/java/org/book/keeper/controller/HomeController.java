package org.book.keeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Bookeeper")
public class HomeController {
	
	@RequestMapping(value={"/welcomeHome"})
	public String homePage() {
		return "welcomeHome";
	}
}
