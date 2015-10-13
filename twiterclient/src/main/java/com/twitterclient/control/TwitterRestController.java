package com.twitterclient.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterRestController {
	@Autowired
	private ConnectionRepository connectionRepository;

	@Autowired
	private Twitter twitter;

	@RequestMapping(value = "/api/twitter/userTimeline", method = RequestMethod.GET)
	public List<Tweet> getHomeTimeline(
			@RequestParam(value = "pageSize", required = false, defaultValue = "100") int pageSize,
			@RequestParam(value = "sinceId", required = false, defaultValue = "0") int sinceId,
			@RequestParam(value = "maxId", required = false, defaultValue = "0") long maxId) {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			throw new RuntimeException();

		} else {
			return twitter.timelineOperations().getHomeTimeline(pageSize, sinceId, maxId);
		}
	}

	@RequestMapping(value = "/api/twitter/userProfile", method = RequestMethod.GET)
	public TwitterProfile getUserProfile() {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			throw new RuntimeException();

		} else {
			return twitter.userOperations().getUserProfile();
		}
	}

	@RequestMapping(value = "/api/twitter/userProfile/{id}", method = RequestMethod.GET)
	public TwitterProfile getUserProfile(@PathVariable Integer id) {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			throw new RuntimeException();

		} else {
			return twitter.userOperations().getUserProfile(id);
		}
	}

}
