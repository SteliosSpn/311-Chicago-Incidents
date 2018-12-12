package com.chicago.controllers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chicago.repositories.AllReportsDAO;
import com.chicago.services.ChicagoService;

@Controller
public class MainController {

	@Autowired
	private ChicagoService myservice;
	
	@Autowired
	private  AllReportsDAO a;
	
	@GetMapping(value = "/index")
	public String initIndex(HttpServletRequest request) {
		request.setAttribute("books", myservice.findAllBooks());
		request.setAttribute("mode", "BOOK_VIEW");
		//System.out.println(myservice.procedure2("Tree Trim",Date.valueOf("2012-01-01"),Date.valueOf("2013-01-01")));
	//	'Tree Trim','2012-01-01','2013-01-01'
		return "index";
	}
	
	/*@RequestMapping(value = "/login")
	public String check() {
		return "login";
	}*/
	
	/*@GetMapping(value = "/updateBook")
	public String initIndex(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("book", myservice.findOne(id));
		request.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}*/
	
	@RequestMapping("/procedure2")
	public String findTicketsByCataogory(HttpServletRequest request/*@PathVariable String request_type, Date mint, Date maxt*/) {
		request.setAttribute("procedure2",a.getProcedure2("Tree Trim", Date.valueOf("2012-01-01"),Date.valueOf("2013-01-01")));
		request.setAttribute("mode", "P2");
		return "results";
	}
}
