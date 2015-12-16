package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.stereotype.Service;

@Service
public class InMemoryActivityService implements ActivityService {
	private Map<Long, Activity> activities = new HashMap<>();
	private long nextId = 0;
	
	@Override
	public Activity findOne(Long id) {
		
		return activities.get(id);
	}

	@Override
	public List<Activity> findAll() {
		
		return new ArrayList<Activity>(activities.values());
	}

	@Override
	public Activity save(Activity activity) {
		if(activity.getId()==null){
			activity.setId(nextId++);
		}
		activities.put(activity.getId(), activity);
		return activity;
	}

	@Override
	public Activity remove(Long id) {
		
		return activities.remove(id);
	}

}
