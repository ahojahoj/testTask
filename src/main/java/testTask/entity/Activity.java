package testTask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "userID")
	private String userID;
	@Id
	@Column(name = "url")
	private String url;
	@Column(name = "kind")
	private String kind;
	@Column(name = "numberOfReplies")
	private int numberOfReplies;
	@Column(name = "numberOfPlusoners")
	private int numberOfPlusoners;
	// each with: URL on Google+, title, kind, numbers of replies, number of
	// plusoners)
	
	public Activity(String id, String url, String kind, int numberOfReplies, int numberOfPlusoners) {
		this.userID = id;
		this.kind = kind;
		this.url = url;
		this.numberOfReplies = numberOfReplies;
		this.numberOfPlusoners = numberOfPlusoners;
	}
	
	public Activity() {
		
	}

	public String getActivityId() {
		return userID;
	}

	public String getActivityUrl() {
		return url;
	}

	public String getActivityKind() {
		return kind;
	}

	public int getNumberOfReplies() {
		return numberOfReplies;
	}

	public int getNumberOfPlusoners() {
		return numberOfPlusoners;
	}

	public void setActivityId(String id) {
		this.userID = id;
	}

	public void setActivityUrl(String url) {
		this.url = url;
	}
	
	public void setActivityKind(String kind) {
		this.kind = kind;
	}

	public void setNumberOfReplies(int numberOfReplies) {
		this.numberOfReplies = numberOfReplies;
	}

	public void setNumberOfPlusoners(int numberOfPlusoners) {
		this.numberOfPlusoners = numberOfPlusoners;
	}

}
