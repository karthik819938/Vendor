package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Location;
import com.app.service.ILocationService;

@Controller
public class LocationController {
	
	@Autowired
	private ILocationService service;
	
	@RequestMapping(value="/regloc",method=RequestMethod.GET)
	public String regLoc()
	{ 
		return "LocationRegister";
	}
	
	@RequestMapping(value="/saveloc",method=RequestMethod.POST)
	public String saveLoc(@ModelAttribute("location")Location loc, ModelMap map)
	{
		int locid =service.saveLocation(loc);
		String msg = "Location modeule is saved to database."+ locid;
		map.addAttribute("msg",msg);
		return "LocationRegister";
	}
		
	//get All loctions to ui
	@RequestMapping(value="/getAllLocs")
	public String getData(ModelMap map)
	{
		List<Location> locs= service.getAllLocations();
		map.addAttribute("locs",locs);
		return "LocationData";
	}
	
	
}
