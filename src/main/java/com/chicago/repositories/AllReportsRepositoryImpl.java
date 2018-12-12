package com.chicago.repositories;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chicago.models.AllReports;
import com.chicago.models.Procedure;

@Repository
//@Transactional(readOnly = true)
public class AllReportsRepositoryImpl implements AllReportsRepositoryCustom{

	 @PersistenceContext
	 EntityManager entityManager;
	
	@Override
	public List<AllReports> getZipCode(int zip_code, int limit) {
		javax.persistence.Query query = entityManager.createNativeQuery("SELECT * FROM public.all_reports as a " +
                "WHERE a.zip_code = ? LIMIT ?;", AllReports.class);
        query.setParameter(1, zip_code);
        query.setParameter(2, limit);
        return query.getResultList();
	}
	
	@Override
	public List<AllReports> getStreetAddress(String street_address, int limit) {
		javax.persistence.Query query = entityManager.createNativeQuery("SELECT * FROM public.all_reports as a " +
                "WHERE a.street_address = ? LIMIT ?;", AllReports.class);
        query.setParameter(1, street_address);
        query.setParameter(2, limit);
        return query.getResultList();
	}

	@Override
	public List<Procedure> getProcedure1(Date mint, Date maxt) {
		javax.persistence.Query query =
				entityManager.createNativeQuery("SELECT * FROM total_requests_in_range(?,?)", Procedure.class);
        query.setParameter(1, mint);
        query.setParameter(2, maxt);
        return query.getResultList();
	}
	
	

}
