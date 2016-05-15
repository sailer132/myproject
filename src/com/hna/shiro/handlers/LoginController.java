package com.hna.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/shiro-login")
	public String login(@RequestParam("username") String username ,@RequestParam("password") String password){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		try {
			subject.login(token);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "shiro-login";
		}
		
		return "shiro-success";
	}
}
