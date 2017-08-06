package testTask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private String gender;
	@Column(name = "url")
	private String url;

	public User(String id, String name, String gender, String url) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.url = url;
	}
	
	public User() {
		
	}
	

	public String getUserId() {
		return id;
	}

	public String getUserName() {
		return name;
	}

	public String getUserGender() {
		return gender;
	}

	public String getUserUrl() {
		return url;
	}

	public void setUserId(String id) {
		this.id = id;
	}

	public void setUserName(String name) {
		this.name = name;
	}

	public void setUserGender(String gender) {
		this.gender = gender;
	}

	public void setUserUrl(String url) {
		this.url = url;
	}

}
