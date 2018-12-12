package com.chicago.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chicago.models.AllReports;
import com.chicago.models.Log;
import com.chicago.repositories.AllReportsRepositoryImpl;
import com.chicago.services.AllReportsService;
import com.chicago.services.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService us;
	@Autowired
	private AllReportsRepositoryImpl arri;
	
	@GetMapping("/searchByStreet")
	public String searchStreet(Model model) {
		model.addAttribute("all_reports", new AllReports());
		return "views/searchStreetForm";
	}
	
	@PostMapping("/searchByStreet")
    public String searchStreetPost(@RequestParam(defaultValue="10") int limit,HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report, BindingResult bindingResult, Model model) {
		model.addAttribute("all_reports", arri.getStreetAddress(report.getStreet_address(), limit));
		us.saveLog(new Log("Searched by Street Address",session.getAttribute("email").toString()));
		return "results/searchResult";
	}
	
	@GetMapping("/searchByZip")
	public String searchZip(Model model) {
		model.addAttribute("all_reports", new AllReports());
		return "views/searchZipForm";
	}
	
	@PostMapping("/searchByZip")
    public String searchZipPost(@RequestParam(defaultValue="10") int limit,HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report, BindingResult bindingResult, Model model) {
		model.addAttribute("all_reports", arri.getZipCode(report.getZip_code(), limit));
		us.saveLog(new Log("Searched by Zip Code",session.getAttribute("email").toString()));
		return "results/searchResult";

	}
	
}
