package com.twitterclient.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	// エラーの場合はクエリストリングにerrorパラメータを付与している。以下は、パラメータを参照してエラーメッセージの追加をしている。
	public String loginForm(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("errros", "ユーザー名もしくはパスワードが誤っています。");
		}
		return "loginForm";

	}

}
