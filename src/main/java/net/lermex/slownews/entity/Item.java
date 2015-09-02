package net.lermex.slownews.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "article")
public class Item {
	@Id
	@Column(name = "title", length = 2000)
	private String title;
	@Column(name = "link", length = 2000)
	private String link;
	@Column(name = "description", length = 2000)
	private String description;
	@Column(name = "pubDate")
	private String pubDate;
	@Column(name = "guid")
	private String guid;
    
    @XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	@XmlElement
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	@Override
	public String toString() {
		
		return  title+
	     link + 
	   description +
	   pubDate+
	     guid;
	}
    
    
    
    
}
