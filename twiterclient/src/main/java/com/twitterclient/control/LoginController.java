package com.twitterclient.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twitterclient.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository repo;

	@RequestMapping("/test")
	public String hoge() {
		return "connect/twitterConnect";
	}

	@RequestMapping("/test2")
	public String hoge2() {
		return "connect/twitterConnected";
	}

	@RequestMapping("/test3")
	public String hoge3() {
		return "aaaa";
	}

	@RequestMapping("loginForm")
	public String loginForm(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("errros", "ユーザー名もしくはパスワードが誤っています。");
		}
		return "loginForm";

	}

}
