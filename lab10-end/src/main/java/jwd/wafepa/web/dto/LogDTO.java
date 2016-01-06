package jwd.wafepa.web.dto;

import java.util.Date;

import jwd.wafepa.model.Log;

public class LogDTO {

	private Long id;
	private Date date;
	private Integer duration;
	private ActivityDTO activity;
	
	public LogDTO() {
	}
	
	public LogDTO(Log log) {
		this.id = log.getId();
		this.date = log.getDate();
		this.duration = log.getDuration();
		this.activity = new ActivityDTO(log.getActivity());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}
}
