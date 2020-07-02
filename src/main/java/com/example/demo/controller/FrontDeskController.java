package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClientInfo;
import com.example.demo.model.RecentlyVisited;
import com.example.demo.model.Reminder;
import com.example.demo.services.ClientInfoService;
import com.example.demo.services.RecentlyVisitedService;
import com.example.demo.services.ReminderService;
@CrossOrigin
@RestController
public class FrontDeskController {

	@Autowired
	ReminderService reminderService;

	@Autowired
	RecentlyVisitedService recentlyVisitedService;
	
	@Autowired
	ClientInfoService clientInfoService;

	@GetMapping
	public String homePage() {
		return "Welcome to FrontDesk Api";
	}
	@GetMapping("/reminder")
	public List<Reminder> getReminders() {
		return reminderService.getReminders();
	}
	
	@PostMapping("/reminder")
	public Reminder addReminder(@RequestBody Reminder reminder) {
		reminderService.addReminder(reminder);
			return reminder;
	}
	@GetMapping("/recentlyVisited")
	public List<RecentlyVisited> getRecentlyVisitedData() {
		return recentlyVisitedService.getRecentlyVisitedData();
	}

	@PostMapping("/recentlyVisited")
	public RecentlyVisited postRecentlyVisitedData(@RequestBody RecentlyVisited recentlyVisited) {
		recentlyVisitedService.postRecenltyVisitedData(recentlyVisited);
		return recentlyVisited;
	}
	
	@GetMapping("/clientInfo")
	public List<ClientInfo> getClientInfo(){
		return clientInfoService.getClientInfo();
	}
	
	@PostMapping("/clientInfo")
	public ClientInfo insertClientInfo(@RequestBody ClientInfo clientInfo) {
		clientInfoService.insertClientInfo(clientInfo);
		return clientInfo;
	}
}
