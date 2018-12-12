package com.chicago.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {

	@GetMapping("/searchResult")
	public String search(Model model, HttpSession session) {
		return "results/SearchResult";
	}
	
	@GetMapping("/procedure1Result")
	public String procedure1(Model model, HttpSession session) {
		return "results/procedure1Result";
	}
	
	@GetMapping("/procedure2Result")
	public String procedure2(Model model, HttpSession session) {
		return "results/procedure2Result";
	}
	
	@GetMapping("/procedure3Result")
	public String procedure3(Model model, HttpSession session) {
		return "results/procedure3Result";
	}
	
}
