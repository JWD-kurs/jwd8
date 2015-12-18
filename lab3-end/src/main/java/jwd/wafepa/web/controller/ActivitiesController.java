package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String deleteActivity(@PathVariable("id") Long id) {
		activityService.remove(id);
		return "redirect:/activities";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addActivity(Model model) {
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		return "addEditActivity";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editActivity(@PathVariable("id") Long id, Model model) {
		Activity activity = activityService.findOne(id);
		model.addAttribute("activity", activity);
		return "addEditActivity";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveActivity(Activity activity) {
		activityService.save(activity);
		return "redirect:/activities";
	}
}
