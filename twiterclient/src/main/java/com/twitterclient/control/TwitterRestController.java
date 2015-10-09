package com.twitterclient.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/twitter")
public class TwitterRestController {
	@Autowired
	private ConnectionRepository connectionRepository;

	@Autowired
	private Twitter twitter;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> getUserTimeline() {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			// TODO
			return null;
		} else {
			return twitter.timelineOperations().getUserTimeline(0);
		}
	}

}
