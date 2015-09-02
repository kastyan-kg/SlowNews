package net.lermex.slownews.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="rss")
public class Rss {
	
	@XmlElementWrapper( name = "channel" )
	@XmlElement( name = "item" )
	private ArrayList<Item> news;

	

	

	public ArrayList<Item> getNews() {
		return news;
	}





	@Override
	public String toString() {
		String  helper = null;
		 for(Item foo: news){
			 helper += foo.toString() + "  ";
			
		}
		 return helper;
	}
	
	

}
