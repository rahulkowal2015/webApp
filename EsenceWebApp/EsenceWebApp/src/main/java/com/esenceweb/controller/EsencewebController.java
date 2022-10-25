package com.esenceweb.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.esenceweb.model.Esenceweb;
import com.esenceweb.service.EsencewebService;

import org.springframework.stereotype.Controller;

@Controller
public class EsencewebController {
	
	@Autowired
	private EsencewebService service; 
	
	@RequestMapping("/")
	public String retrieveAllData(Model model) {
		List<Esenceweb> webs = service.listAll();
		model.addAttribute("web", webs);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String createuserForm(Model model) {
		Esenceweb webs = new Esenceweb();
		model.addAttribute("men", webs);
		
		return "new_user";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("webs") Esenceweb webs) {
		service.save(webs);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_user");
		Esenceweb webs = service.get(id);
		mav.addObject("wan", webs);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}

}
