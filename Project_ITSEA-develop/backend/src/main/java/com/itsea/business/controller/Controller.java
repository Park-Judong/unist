package com.itsea.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsea.business.dto.Email;
import com.itsea.business.service.CustomMailSender;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	CustomMailSender customMailSender;
	
	@PostMapping(path = "/sendEmail")
	public HttpStatus sendEmail(Email email) {
		if(customMailSender.sendMail(email)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
