package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/activities")
public class ActivitiesController {

	// samo za testiranje dok ne napravimo bazu
	@PostConstruct
	public void init() {
		Activity activity = new Activity();
		activity.setName("Coding");
		activityService.save(activity);
		
		activity = new Activity();
		activity.setName("Swimming");
		activityService.save(activity);
	}
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getActivities(Model model) {
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activitiesModel", activities);
		model.addAttribute("activitiesCount", activities.size());
		return "activities";
	}
}
