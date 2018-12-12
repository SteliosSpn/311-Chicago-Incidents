package com.chicago.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chicago.models.AllReports;

@Service
public class ChicagoService{

	/*@Autowired
	private AllReportsRepository allrep;
	
	public Collection<AllReports> findAllReports(){
		List<AllReports> all_reports = new ArrayList<AllReports>();
		for(AllReports report : allrep.findAll()) {
			all_reports.add(report);
		}
		return all_reports;
	}*/
	
	/*@Autowired
	private AllBooksRepository allbooks;
	
	public Collection<Book> findAllBooks(){
		List<Book> all_books = new ArrayList<Book>();
		for(Book report : allbooks.findAll()) {
			if(report.getBook_name().equals("Java")) {
				all_books.add(report);
			}
			
		}
		return all_books;
	}*/
	
	/*public void delete(Integer report_id) {
		allbooks.deleteById(report_id);
	}
	
	public Optional<Book> findOne(Integer id) {
		return allbooks.findById(id);
	}*/
}
