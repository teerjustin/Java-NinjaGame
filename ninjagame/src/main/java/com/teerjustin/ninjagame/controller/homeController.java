package com.teerjustin.ninjagame.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.teerjustin.ninjagame.model.Activity;


@Controller
public class homeController {
	
	public static List<Activity> list=new ArrayList<Activity>();
	
	
	
	
	@RequestMapping("/")
    public String dashboard(HttpSession sesh, Model model) {
		//start
		System.out.println("I AM BACK HOME");
		
		//if no session... create
		if (sesh.isNew()) {
			sesh.setAttribute("gold", 0);
			sesh.setAttribute("activities", "");
			model.addAttribute("gold", sesh.getAttribute("gold"));
			return "index.jsp";
			
		//if session doesnt exist, create
		}
		if (sesh.getAttribute("gold") == null) {
			sesh.setAttribute("gold", 0);
			sesh.setAttribute("activities", "");
			model.addAttribute("gold", sesh.getAttribute("gold"));
			return "index.jsp";
		}
		//if there is a session... just return
		model.addAttribute("gold", sesh.getAttribute("gold"));
		sesh.setAttribute("list", list);
		System.out.println(sesh.getAttribute("list"));
//		sesh.setAttribute("activities", sesh.getAttribute("activities") + "I went to the farm and gained " + sesh.getAttribute("farm") + " gold");
		model.addAttribute("activities", list);
		return "index.jsp";
	}
	
	//GO TO FARM
    @RequestMapping(value="/farm", method=RequestMethod.POST)
    public String farm(HttpSession sesh, Model model) {
          // ... process information and save it to the session
    	System.out.println(sesh.getAttribute("gold"));
    	//give a number between 10 & 20
    	int number = (int)((Math.random() * 10) + 10);
		System.out.println("Random number: " + number);
		int numberToAdd = (int) sesh.getAttribute("gold") + number;
		System.out.println(numberToAdd);
		sesh.setAttribute("gold", numberToAdd);
		
		sesh.setAttribute("amount", number);

		String text =  "I went to the farm and gained " + sesh.getAttribute("amount") + " gold";
		String pattern = "MMMMMMMMMM d, yyyy, hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = "(" + simpleDateFormat.format(new Date()) + ")";
		
		
		
		
		
		Activity a = new Activity(text, true, date);
		sesh.setAttribute("activities", a);
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ" + a.text);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + a.gain);
		list.add((Activity) sesh.getAttribute("activities"));
    	return "redirect:/";
    }
    
	//GO TO CAVE
    @RequestMapping(value="/cave", method=RequestMethod.POST)
    public String cave(HttpSession sesh, Model model) {
    	Random ran = new Random();
    	int x = ran.nextInt(6) + 5;
		System.out.println("Random number: " + x);
		int numberToAdd = (int) sesh.getAttribute("gold") + x;
		System.out.println(numberToAdd);
		sesh.setAttribute("gold", numberToAdd);
		sesh.setAttribute("amount", x);
		
		
		String pattern = "MMMMMMMMMM d, yyyy, hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = "(" + simpleDateFormat.format(new Date()) + ")";
		
		
		
		String text =  "I went to the cave and gained " + sesh.getAttribute("amount") + " gold";
		Activity a = new Activity(text, true, date);
		sesh.setAttribute("activities", a);
		
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ" + a.text);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + a.gain);
		
		
		list.add((Activity) sesh.getAttribute("activities"));
    	return "redirect:/";
    }
    
	//GO TO HOUSE
    @RequestMapping(value="/house", method=RequestMethod.POST)
    public String house(HttpSession sesh, Model model) {
    	Random ran = new Random();
    	int x = ran.nextInt(4) + 2;
		System.out.println("Random number: " + x);
		int numberToAdd = (int) sesh.getAttribute("gold") + x;
		System.out.println(numberToAdd);
		sesh.setAttribute("gold", numberToAdd);
		sesh.setAttribute("amount", x);
		
		String pattern = "MMMMMMMMMM d, yyyy, hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = "(" + simpleDateFormat.format(new Date()) + ")";
		
		
		
		
		
		
		String text =  "I went to the house and gained " + sesh.getAttribute("amount") + " gold";
		Activity a = new Activity(text, true, date);
		sesh.setAttribute("activities", a);
		
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ" + a.text);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + a.gain);
		
		list.add((Activity) sesh.getAttribute("activities"));
    	return "redirect:/";
    }
    
    
	//GO TO CASINO!
    @RequestMapping(value="/casino", method=RequestMethod.POST)
    public String casino(HttpSession sesh, Model model) {
        // ... process information and save it to the session
		System.out.println(sesh.getAttribute("gold"));
		//give a number between -50, 50
		Random ran = new Random();
		int x = ran.ints(-50, (50 + 1)).findFirst().getAsInt();
		System.out.println("Random number: " + x);
		
		int numberToAdd = (int) sesh.getAttribute("gold") + x;
		
		System.out.println(numberToAdd);
		sesh.setAttribute("gold", numberToAdd);
		
		String pattern = "MMMMMMMMMM d, yyyy, hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = "(" + simpleDateFormat.format(new Date()) + ")";
		
		
		
		
		if (x < 0) {
			int lostAmount = -(x);
			sesh.setAttribute("amount", lostAmount);
			String text =  "I went to the casino and LOST " + sesh.getAttribute("amount") + " gold... Ouch";
			Activity a = new Activity(text, false, date); 
			sesh.setAttribute("activities", a);
			
			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ" + a.text);
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + a.gain);
			
		}
		
		if (x > 0) {
			sesh.setAttribute("amount", x);
			
			String text =  "I went to the casino and gained " + sesh.getAttribute("amount") + " gold";
			Activity a = new Activity(text, true, date);
			sesh.setAttribute("activities", a);
			
			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ" + a.text);
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + a.gain);
		}
		list.add((Activity) sesh.getAttribute("activities"));
		return "redirect:/";
	}
    
    @RequestMapping("/invalidate")
    public String invalidate(HttpSession sesh, Model model) {
    	sesh.setAttribute("gold", 0);
    	list.clear();
    	return "redirect:/";
    }
}
























