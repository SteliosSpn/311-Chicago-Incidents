package com.chicago.controllers;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chicago.models.Log;
import com.chicago.repositories.AllReportsDAO;
import com.chicago.repositories.AllReportsRepositoryImpl;
import com.chicago.services.UserService;

@Controller
public class TaskController {

	@Autowired
	private UserService us;
	 @Autowired
	 private AllReportsDAO a;
	 @Autowired
	 private AllReportsRepositoryImpl ari;
	 
	 @GetMapping("/addTask1")
	 public String taskForm1() {
		 return "views/taskForm1";
	 }
	
	 @PostMapping("/addTask1")
	 public String addTask1(HttpSession session,Model model,@RequestParam String min_date,@RequestParam String max_date) {
		 if(min_date.equals(null) || max_date.equals(null)) {
			 model.addAttribute("empty",true);
			 return "views/taskForm1";
		 }
		model.addAttribute("procedure1",ari.getProcedure1(Date.valueOf(min_date),Date.valueOf(max_date)));
		us.saveLog(new Log("Procedure 1",session.getAttribute("email").toString()));
		return  "results/procedure1Result";
	 }
	 
	 @GetMapping("/addTask2")
	 public String taskForm2() {
		 return "views/taskForm2";
	 }
	 
	 @PostMapping("/addTask2")
	 public String addTask2(HttpSession session,Model model,@RequestParam String min_date,@RequestParam String max_date,@RequestParam String type) {
		 if(min_date.equals(null) || max_date.equals(null) || type.equals(null)) {
			 model.addAttribute("empty",true);
			 return "views/taskForm2";
		 }
		model.addAttribute("procedure2",a.getProcedure2(type,Date.valueOf(min_date),Date.valueOf(max_date)));
		us.saveLog(new Log("Procedure 2",session.getAttribute("email").toString()));
		return  "results/procedure2Result";
	 }
	 
	 @GetMapping("/addTask3")
	 public String taskForm3() {
		 return "views/taskForm3";
	 }
	 
	 @PostMapping("/addTask3")
	 public String addTask3(HttpSession session,Model model,@RequestParam String mydate) {
		 if(mydate.equals(null)) {
			 model.addAttribute("empty",true);
			 return "views/taskForm3";
		 }
		model.addAttribute("procedure3",a.getProcedure3(Date.valueOf(mydate)));
		us.saveLog(new Log("Procedure 3",session.getAttribute("email").toString()));
		return  "results/procedure3Result";
	 }
}
