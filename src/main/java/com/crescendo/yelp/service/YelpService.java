package com.crescendo.yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.model.Review;
import com.crescendo.yelp.parser.ReviewParser;
import com.crescendo.yelp.repository.YelpRepository;

@Service
public class YelpService {
	
	@Autowired
	private YelpRepository repository;
	
	@Autowired
	private ReviewParser parser;
	
	public List<Review> getReviews() {
		String response = repository.getReviews();
		return parser.parse(response);
	}
}
