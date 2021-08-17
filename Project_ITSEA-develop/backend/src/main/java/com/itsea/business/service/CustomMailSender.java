package com.itsea.business.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.itsea.business.dto.Email;

@Component
public class CustomMailSender {

	@Value("${spring.mail.username}")
	private String emailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(Email email) {
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		메일 제목
			try {
				helper.setSubject(MimeUtility.encodeText(email.getSubject(), "UTF-8", "B"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return false;
			}
//		수신자 설정
			helper.setTo(emailSender);

			StringBuilder content = new StringBuilder();
			content.append("<label for='name'>이름</label>").append("<input type='text' readonly='readonly' value=")
					.append(email.getName()).append("><br/>");
			content.append("<label for='email'>이메일주소</label>").append("<input type='text' readonly='readonly' value=")
					.append(email.getEmail()).append("><br/>");
			content.append("<label for='country'>국적</label>").append("<input type='text' readonly='readonly' value=")
					.append(email.getCountry()).append("><br/>");
			content.append("<label for='content'>내용</label>");
			content.append(email.getContent());

			message.setContent(content.toString(), "text/html; charset=UTF-8");
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
