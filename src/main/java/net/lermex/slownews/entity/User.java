package net.lermex.slownews.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "login")
public class User {
	@Id
	@Column(name = "login")
	private String login;
	@Column(name = "digestPassword")
	private String digestPassword;
	
	public User() {
		super();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getDigestPassword() {
		return digestPassword;
	}
	public void setDigestPassword(String digestPassword) {
		this.digestPassword = digestPassword;
	}
	
	
}
	
