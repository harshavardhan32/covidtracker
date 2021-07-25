package com.example.demo;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class caronavirusdataservice {
	
	private String virusdata="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports_us/01-01-2021.csv";
	
	List<datacarona> gh=new ArrayList<>();
	
	
	
	
	public List<datacarona> getGh() {
		return gh;
	}




	@PostConstruct
	@Scheduled(cron = "* * * * * *")
	public void fetchvirusdata() throws IOException, InterruptedException {
		
		HttpClient k=HttpClient.newHttpClient();
		
		HttpRequest jk=HttpRequest.newBuilder()
				  .uri(URI.create(virusdata))
				  .build();
		
			HttpResponse<String> send = k.send(jk, HttpResponse.BodyHandlers.ofString());
		
			List<datacarona> gh1=new ArrayList<>();
		
		
		StringReader in=new StringReader(send.body());
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			
			datacarona ju=new datacarona();
			
		    ju.setState(record.get("Province_State"));
		   
		    
		    ju.setCountry(record.get("Country_Region"));
		    
		    
		    ju.setConformed(Integer.parseInt(record.get("Confirmed")));
		    
		    
		    ju.setLastupdated(record.get("Last_Update"));
		    gh1.add(ju);
		    System.out.println(ju);
		  
		}
		
		this.gh=gh1;
		
	}

}
