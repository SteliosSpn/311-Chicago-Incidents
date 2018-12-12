package com.chicago.repositories;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chicago.models.Procedure;

@Repository
public class AllReportsDAO {

	@Autowired
	private EntityManager em;
	
	public List<Object> getProcedure2(String request_type, Date mint, Date maxt) {
		StoredProcedureQuery addBookStoredProcedure = em.createStoredProcedureQuery("total_requests_per_day_in_range");
		addBookStoredProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN); 
		addBookStoredProcedure.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN); 
		addBookStoredProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);  
		// Setting stored procedure parameters.
		addBookStoredProcedure.setParameter(1, request_type);
		addBookStoredProcedure.setParameter(2, mint);
		addBookStoredProcedure.setParameter(3, maxt);
		 
		// Stored procedure call
		List results = addBookStoredProcedure.getResultList();
		 
		for(Integer i=0;i<results.size();i++) {
		 
		    String objects =  results.get(i).toString();
		 
		    System.out.println(objects);
		}
		return addBookStoredProcedure.getResultList();
	}
	
	public List<Procedure> getProcedure1(Date mint, Date maxt) {
		StoredProcedureQuery spq = em.createStoredProcedureQuery("total_requests_in_range");
		spq.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN); 
		spq.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		spq.setParameter(1, mint);
		spq.setParameter(2, maxt);
		// Stored procedure call
		List results = spq.getResultList();
		System.out.println(spq.getOutputParameterValue(3));
		 
		for(Integer i=0;i<results.size();i++) {
		 
		    String objects =  results.get(i).toString();
		 
		    //System.out.println(objects.getRequest_per_type());
		}
		return spq.getResultList();
	}
	
	public List<Object> getProcedure3(Date mydate) {
		StoredProcedureQuery addBookStoredProcedure = em.createStoredProcedureQuery("most_common_service_request");
		addBookStoredProcedure.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);  
		
		addBookStoredProcedure.setParameter(1, mydate);
		 
		// Stored procedure call
		List results = addBookStoredProcedure.getResultList();
		 
		for(Integer i=0;i<results.size();i++) {
		 
		    String objects =  results.get(i).toString();
		 
		    System.out.println(objects);
		}
		return addBookStoredProcedure.getResultList();
	}
	
}
