package com.lti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.demo.dao.AlienRepo;
import com.lti.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView("showalien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		//mv.addObject(alien);
		
		System.out.println(repo.findByAname("vishal"));
		System.out.println(repo.findByAidGreaterThan(101));
		
		mv.addObject(alien);
		return mv;
	}
}
