package com.crescendo.yelp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class YelpRepository {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getReviews() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
	    headers.set("x-requested-with", "XMLHttpRequest");
	     					
	    final HttpEntity<String> entity = new HttpEntity<String>(headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange("https://www.yelp.com/biz/jJwwrFaVJdlwMJjtXsLJmQ/props", HttpMethod.GET, entity, String.class);
	    return response.getBody();
	}
}
