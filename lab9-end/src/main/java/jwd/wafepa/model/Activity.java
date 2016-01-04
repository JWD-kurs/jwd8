package jwd.wafepa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tblActivity")
public class Activity {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="activity")
	private Set<Log> logs;
	
	private String adminComment;
	
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
	public String getAdminComment() {
		return adminComment;
	}
	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	public Set<Log> getLogs() {
		return logs;
	}
	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}
}
