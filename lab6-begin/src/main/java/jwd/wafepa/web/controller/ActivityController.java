package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostConstruct
	private void init() {
		// Activity activityRunning = new Activity();
		// activityRunning.setName("Running");
		//
		// Activity activitySwimming = new Activity();
		// activitySwimming.setName("Swimming");
		//
		// activityService.save(activityRunning);
		// activityService.save(activitySwimming);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getActivities(Model model) {
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activitiesModel", activities);
		model.addAttribute("activitiesCount", activities.size());
		return "activities";
	}

	@RequestMapping(value = "/remove/{id}")
	public String remove(@PathVariable Long id) {
		activityService.remove(id);
		return "redirect:/activities";
	}

	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("activity", new Activity());
		return "addEditActivity";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("activity", activityService.findOne(id));

		return "addEditActivity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(Activity activity, BindingResult bindingResult,
			Model model) {

		activityService.save(activity);
		return "redirect:/activities";

	}

	@RequestMapping("name/{name}")
	public String findByName(Model model, @PathVariable String name) {
		List<Activity> activities = activityService.findByName(name);
		model.addAttribute("activitiesModel", activities);
		return "activities";
	}

}
