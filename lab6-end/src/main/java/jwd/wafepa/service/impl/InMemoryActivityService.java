package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.stereotype.Service;

//@Service
public class InMemoryActivityService implements ActivityService {

	private Map<Long, Activity> data = new HashMap<>();
	private Long idCounter = 1L;
	
	@Override
	public Activity findOne(Long id) {
		return data.get(id);
	}

	@Override
	public List<Activity> findAll() {
		return new ArrayList<>(data.values());
	}

	@Override
	public Activity save(Activity activity) {
		if (activity.getId() == null) {
			activity.setId(idCounter);
			idCounter++;
		}
		data.put(activity.getId(), activity);
		return activity;
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Activity activity = data.remove(id);
		if (activity == null) {
			throw new IllegalArgumentException("Removing unexisting activity with id=" + id);
		}
	}

	@Override
	public List<Activity> findByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
