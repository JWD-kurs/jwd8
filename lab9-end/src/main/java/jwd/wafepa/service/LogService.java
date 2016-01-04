package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Log;

public interface LogService {

	Log findOne(Long id);
	List<Log> findAll();
	Log save(Log log);
	void remove(Long id) throws IllegalArgumentException;
}
