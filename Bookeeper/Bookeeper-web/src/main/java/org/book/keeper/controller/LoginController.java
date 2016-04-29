package org.book.keeper.controller;

import org.book.keeper.model.ErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Bookeeper")
public class LoginController {

	@RequestMapping(value = {"/","/loginPage"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("loginPage");
        return model;
    }
	
	@RequestMapping(value = {"/loginPageError"})
	public String validationIssue(Model model) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorMsg("Invalid UserName and/or Password!");
		model.addAttribute("errorMessage",error);
		return "loginPage";
	}
	
	@RequestMapping(value={"/accessDenied"})
	public String accessDenied() {
		return "accessDenied";
	}
}
