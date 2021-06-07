package com.crescendo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.model.Review;
import com.crescendo.yelp.service.YelpService;

@RestController
public class ReviewController {
	@Autowired
	private YelpService service;
	
	@GetMapping(path = "/reviews", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Review>> getReviews() {
		return new ResponseEntity<>(service.getReviews(), HttpStatus.OK);
	}
}

