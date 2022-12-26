package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Billing;
import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.services.BillingService;
import com.zohocrmapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private BillingService billingService;
	
	
	@Autowired
	private ContactService contactService;
	
	
	//http://localhost:8080/ListContacts
	@RequestMapping("/ListContacts")
	public String ListContact(Model model) {
		List<Contacts> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return "List_Contact";
	}
	
	@RequestMapping("/createBill")
	public String CreateBill(@RequestParam("id")long id,Model model) {
		Contacts contacts = contactService.getContactById(id);
		model.addAttribute("contacts", contacts);
		return "	";
	}
		@RequestMapping("saveBill")
		public String SaveBill(Billing bill) {
			billingService.generateBill(bill);
			return "list_Bill";
			
		}

}
