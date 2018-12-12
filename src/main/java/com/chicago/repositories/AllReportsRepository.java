package com.chicago.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chicago.models.AllReports;

public interface AllReportsRepository extends JpaRepository<AllReports, Integer>, AllReportsRepositoryCustom{
	@Query("select max(report_id) from AllReports")
    Integer maxprimkey();
	
	/*@Query(value = "SELECT street_address,type_of_service_request from public.all_reports WHERE zip_code = 123", nativeQuery = true)
    public Object[][] searchByZip();*/
}
