package com.chicago.services;

import java.sql.Timestamp;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chicago.models.AbandonedVehicles;
import com.chicago.models.AllReports;
import com.chicago.models.GarbageCart;
import com.chicago.models.GraffitiRemoval;
import com.chicago.models.PotHolesReported;
import com.chicago.models.RobentBaiting;
import com.chicago.models.SanitationCodeComplaint;
import com.chicago.models.TreeDebris;
import com.chicago.models.TreeTrims;
import com.chicago.repositories.AbandonedVehicleRepository;
import com.chicago.repositories.AllReportsRepository;
import com.chicago.repositories.GarbageCartRepository;
import com.chicago.repositories.GraffitiRemovalRepository;
import com.chicago.repositories.PotHolesRepository;
import com.chicago.repositories.RodentBaitingRepository;
import com.chicago.repositories.SanitationCodeRepository;
import com.chicago.repositories.TreeDebrisRepository;
import com.chicago.repositories.TreeTrimsRepository;

@Service
public class AllReportsService {

	@Autowired
	private AllReportsRepository arr;
	
	@Autowired
	private AbandonedVehicleRepository avr;
	
	@Autowired
	private GarbageCartRepository gcr;
	
	@Autowired
	private GraffitiRemovalRepository grr;
	
	@Autowired
	private PotHolesRepository phr;
	
	@Autowired
	private RodentBaitingRepository rbr;
	
	@Autowired
	private SanitationCodeRepository scr;
	
	@Autowired
	private TreeDebrisRepository tdr;
	
	@Autowired
	private TreeTrimsRepository ttr;
	
	@Autowired
	private AllReportsRepository ap;
	
	public AllReports findOne(int report_id) {
		  return arr.findOne(report_id);
	}
	
	public AbandonedVehicles findOneAV(int report_id) {
		  return avr.findOne(report_id);
	}
	
	public GarbageCart findOneGC(int report_id) {
		  return gcr.findOne(report_id);
	}
	
	public GraffitiRemoval findOneGR(int report_id) {
		  return grr.findOne(report_id);
	}
	
	public PotHolesReported findOnePH(int report_id) {
		  return phr.findOne(report_id);
	}
	
	public RobentBaiting findOneRB(int report_id) {
		  return rbr.findOne(report_id);
	}
	
	public SanitationCodeComplaint findOneSC(int report_id) {
		  return scr.findOne(report_id);
	}
	
	public TreeDebris findOneTD(int report_id) {
		  return tdr.findOne(report_id);
	}
	
	public TreeTrims findOneTT(int report_id) {
		  return ttr.findOne(report_id);
	}
	
	public boolean reportNumberExists(int report_id) {
		
		AllReports report=arr.findOne(report_id);
		if(report!=null)
			return true;
		
		return false;
	}
	
	public void createReport(AllReports report, AbandonedVehicles vehicle) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Abandoned Vehicle");
		arr.save(report);
		vehicle.setReport_id(ap.maxprimkey());
		avr.save(vehicle);
	}
	
	public void createReport(AllReports report, GarbageCart cart) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Garbage Cart Black Maintenance/Replacement");
		report.setLocation_desc("desc");
		arr.save(report);
		cart.setReport_id(ap.maxprimkey());
		gcr.save(cart);
	}
	
	public void createReport(AllReports report, GraffitiRemoval graffiti) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Graffiti Removal");
		report.setLocation_desc("desc");
		arr.save(report);
		graffiti.setReport_id(ap.maxprimkey());
		grr.save(graffiti);
	}
	
	public void createReport(AllReports report, PotHolesReported holes) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Pothole in Street");
		report.setLocation_desc("desc");
		arr.save(report);
		holes.setReport_id(ap.maxprimkey());
		phr.save(holes);
	}
	
	public void createReport(AllReports report, RobentBaiting rodent) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Rodent Baiting/Rat Complaint");
		report.setLocation_desc("desc");
		arr.save(report);
		rodent.setReport_id(ap.maxprimkey());
		rbr.save(rodent);
	}

	public void createReport(AllReports report, SanitationCodeComplaint sanitation) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Sanitation Code Violation");
		report.setLocation_desc("desc");
		arr.save(report);
		sanitation.setReport_id(ap.maxprimkey());
		scr.save(sanitation);
	}
	
	public void createReport(AllReports report, TreeDebris debris) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Tree Debris");
		report.setLocation_desc("desc");
		arr.save(report);
		debris.setReport_id(ap.maxprimkey());
		tdr.save(debris);
	}
	
	public void createReport(AllReports report, TreeTrims trims) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request("Tree Trim");
		report.setLocation_desc("desc");
		arr.save(report);
		trims.setReport_id(ap.maxprimkey());
		ttr.save(trims);
	}
	
	public void createReport(AllReports report,String type) {
		report.setCreation_date(new Timestamp(System.currentTimeMillis()));
		report.setStatus("Open");
		report.setService_request_number(generateRandom(12));
		report.setType_of_service_request(type);
		report.setLocation_desc("desc");
		arr.save(report);
	}
	
	public static String generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return (new String(digits));
	}
	
	public void updateReport(AllReports report, AbandonedVehicles vehicle) {
		arr.save(report);
		avr.save(vehicle);
	}
	
	public void updateReport(AllReports report, GarbageCart cart) {
		arr.save(report);
		gcr.save(cart);
	}
	
	public void updateReport(AllReports report, GraffitiRemoval graffiti) {
		arr.save(report);
		grr.save(graffiti);
	}
	
	public void updateReport(AllReports report, PotHolesReported hole) {
		arr.save(report);
		phr.save(hole);
	}
	
	public void updateReport(AllReports report, RobentBaiting rodent) {
		arr.save(report);
		rbr.save(rodent);
	}
	
	public void updateReport(AllReports report, SanitationCodeComplaint sanitation) {
		arr.save(report);
		scr.save(sanitation);
	}
	
	public void updateReport(AllReports report, TreeDebris debris) {
		arr.save(report);
		tdr.save(debris);
	}
	
	public void updateReport(AllReports report, TreeTrims trim) {
		arr.save(report);
		ttr.save(trim);
	}
	
	public void updateReport(AllReports report) {
		arr.save(report);
	}
	
}
