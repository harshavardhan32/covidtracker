package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class conhome {
	
	@Autowired
	caronavirusdataservice caronavirusdataservice;
	
	
	@RequestMapping("/home")
	public String ho(Model kl) {
		
	List<datacarona>	wai=caronavirusdataservice.getGh();
	
	int totalReportedCases = wai.stream().mapToInt(stat -> stat.getConformed()).sum();
		
		kl.addAttribute("hai",wai);
		
		kl.addAttribute("ii", totalReportedCases);
		
		return"NewFile";
	}

}
