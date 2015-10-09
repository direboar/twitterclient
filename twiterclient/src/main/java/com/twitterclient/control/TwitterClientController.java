package com.twitterclient.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TwitterClientController {
	@Autowired
	private ConnectionRepository connectionRepository;

	@RequestMapping("/twitter")
	public String twitter(Model model) {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			return "redirect:/connect/twitter";
		}
		return "/connect/twitterConnected";
	}

}
