package com.chicago.repositories;

import java.sql.Date;
import java.util.List;

import com.chicago.models.AllReports;
import com.chicago.models.Procedure;

public interface AllReportsRepositoryCustom {

	List<AllReports> getZipCode(int zip_code, int limit);
	List<AllReports> getStreetAddress(String street_address, int limit);
	List<Procedure> getProcedure1(Date mint, Date maxt);
}
