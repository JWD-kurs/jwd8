package jwd.wafepa.web.dto;

import jwd.wafepa.model.Activity;

public class ActivityDTO {
	private Long id;
	private String name;
	
	public ActivityDTO() {
		super();
	}

	public ActivityDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ActivityDTO(Activity activity){
		super();
		this.id = activity.getId();
		this.name = activity.getName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
