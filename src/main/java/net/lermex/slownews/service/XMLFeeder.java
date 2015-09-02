package net.lermex.slownews.service;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.lermex.slownews.entity.Rss;
import net.lermex.slownews.service.*;
public class XMLFeeder {

	public  Rss getNews() throws JAXBException, IOException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.kyivpost.com/rss/?content_type=story&section=4");
		String rss1 = target.request().get().readEntity(String.class);
		
		File file = new File("D:/java/infopuls/svyatoslav/SlowNews-maven-starting-point/SlowNews/src/main/webapp/Files/fileRSS.txt");
		
		FileOutputStream fw = new FileOutputStream(file);
		byte[] contentInBytes =rss1.getBytes("UTF-8");
		fw.write(contentInBytes);
		fw.flush();
		fw.close();
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Rss rss = (Rss) jaxbUnmarshaller.unmarshal(file);
			return rss;

            
	

	}

}
