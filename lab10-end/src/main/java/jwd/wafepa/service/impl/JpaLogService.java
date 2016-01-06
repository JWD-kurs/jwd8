package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.spi.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Log;
import jwd.wafepa.repository.LogRepository;
import jwd.wafepa.service.LogService;

@Transactional
@Service
public class JpaLogService implements LogService {

	@Autowired
	private LogRepository logRepository;
	
	@Override
	public Log findOne(Long id) {
		return logRepository.findOne(id);
	}

	@Override
	public List<Log> findAll() {
		return logRepository.findAll();
	}

	@Override
	public Log save(Log log) {
		return logRepository.save(log);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		logRepository.delete(id);
	}

}
