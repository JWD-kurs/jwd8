package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;

import org.springframework.data.domain.Page;

public interface ActivityService {

	Activity findOne(Long id);
	Page<Activity> findAll(int page);
	Activity save(Activity activity);
	void remove(Long id) throws IllegalArgumentException;
	List<Activity> findByName(String string);
}
