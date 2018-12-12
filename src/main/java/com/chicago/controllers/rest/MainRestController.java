package com.chicago.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chicago.models.AllReports;
import com.chicago.models.Book;
import com.chicago.services.ChicagoService;

@RestController
public class MainRestController {
	
	@Autowired
	private ChicagoService myservice;
	
	/*@GetMapping(value = "/")
	public String hello() {
		return "hello world bob";
	}*/
	
	/*@GetMapping(value = "/AllReports")
	public Collection<AllReports> getAllReports() {
		return myservice.findAllReports();
	}*/
	
	@GetMapping(value = "/AllBooks")
	public Collection<Book> getAllBooks() {
		return myservice.findAllBooks();
	}
	
	/*@GetMapping(value = "/delete")
	public void deleteReport(@RequestParam int report_id) {
		myservice.delete(report_id);
	}*/
	
}
