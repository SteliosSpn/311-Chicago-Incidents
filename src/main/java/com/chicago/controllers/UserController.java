package com.chicago.controllers;


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
import com.chicago.repositories.AllReportsRepositoryImpl;
import com.chicago.services.AllReportsService;
import com.chicago.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AllReportsService ars;
	
	@GetMapping("/users")
	public String listUsers(Model model, @RequestParam(defaultValue="")  String name) {
		model.addAttribute("users", userService.findByName(name));
		return "views/list";
	}
	
	@GetMapping("/procedures")
	public String listProcedures() {
		return "views/procedurelist";
	}
	
	@GetMapping("/incident")
	public String listIncidents(HttpSession session) {
		session.removeAttribute("report_id");
		return "views/incidentlist";
	}
	
	@GetMapping("/search")
	public String search() {
		return "views/searchlist";
	}

	@GetMapping("/modify")
	public String modify(Model model, HttpSession session) {
		session.removeAttribute("report_id");
		model.addAttribute("all_reports", new AllReports());
		return "views/modify";
	}
	
	
	@PostMapping("/modify")
    public String modifyReport(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report, BindingResult bindingResult, Model model) {
		if(!ars.reportNumberExists(report.getReport_id())) {
			model.addAttribute("not_exist",true);

			return "views/modify";

		}
		report = ars.findOne(report.getReport_id());
		session.setAttribute("report_id", report.getReport_id());
		
		if(report.getType_of_service_request().equals("Abandoned Vehicle") || report.getType_of_service_request().equals("Abandoned Vehicle Complaint")) {
			return "redirect:/addComplaint1";
		}
		if(report.getType_of_service_request().equals("Pothole in Street") || report.getType_of_service_request().equals("Pot Hole in Street")) {
			return "redirect:/addComplaint4";
		}
		if(report.getType_of_service_request().equals("Tree Debris")) {
			return "redirect:/addComplaint7";
		}
		if(report.getType_of_service_request().equals("Graffiti Removal")) {
			return "redirect:/addComplaint3";
		}
		if(report.getType_of_service_request().equals("Garbage Cart Black Maintenance/Replacement")) {
			return "redirect:/addComplaint2";
		}
		if(report.getType_of_service_request().equals("Tree Trim")) {
			return "redirect:/addComplaint8";
		}
		if(report.getType_of_service_request().equals("Rodent Baiting/Rat Complaint")) {
			return "redirect:/addComplaint5";
		}
		if(report.getType_of_service_request().equals("Sanitation Code Violation")) {
			return "redirect:/addComplaint6";
		}
		if(report.getType_of_service_request().equals("Street Lights - All/Out") || report.getType_of_service_request().equals("Street Light Out") || report.getType_of_service_request().equals("Alley Light Out") || report.getType_of_service_request().equals("Street Light - 1/Out")) {
			return "redirect:/addComplaint9";
		}
		return "views/success";

	}

}
