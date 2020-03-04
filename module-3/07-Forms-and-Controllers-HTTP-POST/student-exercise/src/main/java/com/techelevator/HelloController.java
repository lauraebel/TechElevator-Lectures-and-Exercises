package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class HelloController {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(path="/homePage", method=RequestMethod.GET)
	public String showReviews(HttpServletRequest request) {
		request.setAttribute("reviews", reviewDao.getAllReviews());	
		return "homePage";
	}
	
	@RequestMapping(path="/createReview", method=RequestMethod.GET)
	public String createBookReviewForm() {
		return "addReview";
	}

	@RequestMapping(path="/reviewInput", method=RequestMethod.POST)
	public String addReview(@RequestParam(required = true) String username, @RequestParam(required = true) int rating, @RequestParam(required = true) String title, @RequestParam(required = true) String text) {
	Review review = new Review();
		review.setUsername(username);
		review.setRating(rating);
		review.setTitle(title);
		review.setText(text);
		review.setDateSubmitted(LocalDateTime.now());
		
		reviewDao.save(review);
		
		return "redirect:/homePage";
	}
	


}
