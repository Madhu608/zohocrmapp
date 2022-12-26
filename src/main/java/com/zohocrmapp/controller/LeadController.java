package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LeadService leadService;
	//http://localhost:8080/createLead
	@RequestMapping(value = "/createLead",method = RequestMethod.GET)
	public String viewCreateLeadFrom() {
		return "create_lead";
	
	}
	@RequestMapping(value = "saveLead",method = RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("lead") Lead lead, Model model) {
		leadService.saveOneLead(lead);
			model.addAttribute("lead", lead);
		  return"lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id")long id,Model model){
		Lead lead = leadService.getLeadById(id);
		
		Contacts contact = new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		List<Contacts> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return"List_Contact";
	}
	//http://localhost:8080/ListLeads
	@RequestMapping("/ListLeads")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.getAllLead();
		model.addAttribute("leads", leads);
		return "List_Leads";
		}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id ,Model model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
}
