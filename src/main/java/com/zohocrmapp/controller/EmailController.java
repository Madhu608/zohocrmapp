package com.zohocrmapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.util.Emailservice;


@Controller
public class EmailController {
	
			@Autowired
			private Emailservice emailservice;
 
			@RequestMapping(value = "/composeEmail", method = RequestMethod.POST)		
			public String composeEmail(@RequestParam("email") String email, Model model) {
		   model.addAttribute("email", email);
		   return"compose_email";
			
		}
			@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
			public String sendEmail(@RequestParam("to")String to,@RequestParam("sub") String sub,@RequestParam("msg") String msg, Model model) {
				emailservice.SendEmail(to, sub, msg);
				model.addAttribute("msg", "Email Send");
				return"compose_email";
				
			}
}
