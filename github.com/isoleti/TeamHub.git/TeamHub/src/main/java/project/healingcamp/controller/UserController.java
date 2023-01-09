package project.healingcamp.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.healingcamp.service.UserService;
import project.healingcamp.vo.UserVo;


@RequestMapping("/user")
@Controller

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVo vo, HttpSession session) {
		UserVo loginVo = userService.login(vo);
		System.out.println("loginVo"+loginVo);
			if(loginVo ==null) {
				return "user/login";
			} else{
				session.setAttribute("login", loginVo);
				System.out.println(loginVo.toString());
				return "redirect:/";
			}
		
	}
	
}
