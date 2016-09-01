package com.hanbit.web.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * git add --all
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		logger.info("serverTime : {}", formattedDate);
		return "public:public/content.tiles";
	}
	@RequestMapping("/public/school_info")
	public String moveSchoolInfo(){
		logger.info("HomeController! school_info..");
		return "public:public/school_info.tiles";
	}
	@RequestMapping("/public/school_map")
	public String moveWay(){
		logger.info("HomeController! school_map..");
		return "public:public/school_map.tiles";
	}

}
