package com.crescendo.yelp.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.crescendo.model.Review;

@Component
public class ReviewParser {
	
	public List<Review> parse(String json) {
		JSONObject obj = new JSONObject(json);
		JSONObject bizDetailsPageProps = obj.getJSONObject("bizDetailsPageProps");
		JSONObject reviewFeedQueryProps = bizDetailsPageProps.getJSONObject("reviewFeedQueryProps");
		JSONArray reviews = reviewFeedQueryProps.getJSONArray("reviews");
		
		List<Review> results = new ArrayList<>();
		for(int r=0; r<reviews.length(); r++) {
			Review review = new Review();
			JSONObject reviewNode = (JSONObject) reviews.get(r);
			
			JSONObject user = reviewNode.getJSONObject("user");
			review.setUser(user.getString("markupDisplayName"));
			review.setLocation(user.getString("displayLocation"));
			
			JSONObject comment = reviewNode.getJSONObject("comment");
			review.setReview(comment.getString("text"));
			results.add(review);
		}
		
		return results;
	}
}
