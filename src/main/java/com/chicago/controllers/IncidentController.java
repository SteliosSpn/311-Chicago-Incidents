package com.chicago.controllers;

import java.sql.Timestamp;

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

import com.chicago.models.AbandonedVehicles;
import com.chicago.models.AllReports;
import com.chicago.models.GarbageCart;
import com.chicago.models.GraffitiRemoval;
import com.chicago.models.Log;
import com.chicago.models.PotHolesReported;
import com.chicago.models.RobentBaiting;
import com.chicago.models.SanitationCodeComplaint;
import com.chicago.models.TreeDebris;
import com.chicago.models.TreeTrims;
import com.chicago.repositories.AllReportsRepository;
import com.chicago.services.AllReportsService;
import com.chicago.services.UserService;

@Controller
public class IncidentController {

	@Autowired
	private UserService us;
	
	@Autowired
	private AllReportsService ars;
	
	@Autowired
	private AllReportsRepository ap;
	
	 @GetMapping("/addComplaint1")
	 public String abandonedVehiclesForm(Model model, HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("abandoned_vehicles",ars.findOneAV((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm1";
		 }
		 model.addAttribute("abandoned_vehicles", new AbandonedVehicles());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm1";
	 }
	 
	 @PostMapping("/addComplaint1")
	 	public String abandonedVehiclesEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("abandoned_vehicles") AbandonedVehicles vehicle, Model model) {
			if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm1";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				vehicle.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, vehicle);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm1";
			}
			ars.createReport(report,vehicle);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";
		}
	 
	 @GetMapping("/addComplaint2")
	 public String garbageCartForm(Model model, HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("garbage_cart",ars.findOneGC((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm2";
		 }
		 model.addAttribute("garbage_cart", new GarbageCart());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm2";
	 }
	 
	 @PostMapping("/addComplaint2")
	    public String garbageCartEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("garbage_cart") GarbageCart cart, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm2";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				cart.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, cart);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm2";
			}
			ars.createReport(report,cart);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";
		}
	 
	 @GetMapping("/addComplaint3")
	 public String graffitiRemovalForm(Model model,HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("graffiti_removal",ars.findOneGR((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm3";
		 }
		 model.addAttribute("graffiti_removal", new GraffitiRemoval());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm3";
	 }
	 
	 @PostMapping("/addComplaint3")
	    public String graffitiRemovalEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("graffiti_removal") GraffitiRemoval graffiti, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm3";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				graffiti.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, graffiti);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm3";
			}
			ars.createReport(report,graffiti);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";
		}
	 
	 @GetMapping("/addComplaint4")
	 public String potHolesForm(Model model, HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("pot_holes_reported",ars.findOnePH((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm4";
		 }
		 model.addAttribute("pot_holes_reported", new PotHolesReported());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm4";
	 }
	 
	 @PostMapping("/addComplaint4")
	    public String potHolesEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("pot_holes_reported") PotHolesReported hole, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm4";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				hole.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, hole);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm4";
			}
			ars.createReport(report,hole);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";
		}
	 
	 @GetMapping("/addComplaint5")
	 public String rodentBaitingForm(Model model, HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("robent_baiting",ars.findOneRB((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm5";
		 }
		 model.addAttribute("robent_baiting", new RobentBaiting());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm5";
	 }
	 
	 @PostMapping("/addComplaint5")
	    public String rodentBaitingEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("robent_baiting") RobentBaiting rodent, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm5";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				rodent.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, rodent);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm5";
			}
			ars.createReport(report,rodent);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";
		}
	 
	 @GetMapping("/addComplaint6")
	 public String sanitationCodeForm(Model model,HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("sanitation_code_complaints",ars.findOneSC((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm6";
		 }
		 model.addAttribute("sanitation_code_complaints", new SanitationCodeComplaint());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm6";
	 }
	 
	 @PostMapping("/addComplaint6")
	    public String sanitationCodeEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("sanitation_code_complaints") SanitationCodeComplaint sanitation, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm6";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				sanitation.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, sanitation);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm6";
			}
			ars.createReport(report,sanitation);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";

		}
	 
	 @GetMapping("/addComplaint7")
	 public String treeDebrisForm(Model model,HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("tree_debris",ars.findOneTD((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm7";
		 }
		 model.addAttribute("tree_debris", new TreeDebris());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm7";
	 }
	 
	 @PostMapping("/addComplaint7")
	    public String treeDebrisEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("tree_debris") TreeDebris debris, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm7";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				debris.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, debris);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm7";
			}
			ars.createReport(report,debris);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";

		}
	 
	 @GetMapping("/addComplaint8")
	 public String treeTrimsForm(Model model,HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("tree_trims",ars.findOneTT((int)session.getAttribute("report_id")));
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm8";
		 }
		 model.addAttribute("tree_trims", new TreeTrims());
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm8";
	 }
	 
	 @PostMapping("/addComplaint8")
	    public String treeTrimsEx(HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, @Valid @ModelAttribute("tree_trims") TreeTrims trim, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm8";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				trim.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report, trim);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm8";
			}
			ars.createReport(report,trim);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";

		}
	 
	 @GetMapping("/addComplaint9")
	 public String lightsForm(Model model,HttpSession session) {
		 if(session.getAttribute("report_id") != null) {
			 model.addAttribute("all_reports", ars.findOne((int)session.getAttribute("report_id")));
			 return "complaintUpdates/incidentForm9";
		 }
		 model.addAttribute("all_reports", new AllReports());
		 return "complaints/incidentForm9";
	 }
	
	 @PostMapping("/addComplaint9")
	    public String lightsEx(@RequestParam String type,HttpSession session,@Valid @ModelAttribute("all_reports") AllReports report,BindingResult bindingResult, Model model) {
		 if(session.getAttribute("report_id") != null) {
				if(bindingResult.hasErrors()) {
					return "complaintUpdates/incidentForm9";
				}
				report.setReport_id((int)session.getAttribute("report_id"));
				ars.updateReport(report);
				session.setAttribute("report_id", report.getReport_id());
				
				us.saveLog(new Log("Updated report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
				return "views/modifySuccess";
			}
			if(bindingResult.hasErrors()) {
				return "complaints/incidentForm9";
			}
			ars.createReport(report,type);
			session.setAttribute("report_id", ap.maxprimkey());
			us.saveLog(new Log("Inserted report with number "+ report.getReport_id(),session.getAttribute("email").toString()));
			return "views/incidentSuccess";

		}
	 
}
