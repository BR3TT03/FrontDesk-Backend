package com.example.demo.controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reminder;
import com.example.demo.services.ReminderService;
@CrossOrigin(origins = "*")
@RestController
public class ReminderController  {

	@Autowired
	ReminderService reminderService;
	
	@GetMapping("/reminder")
	public List<Reminder> getReminders() {
		return reminderService.getReminders();
	}
	
	@PostMapping("/reminder")
	public Reminder addReminder(@RequestBody Reminder reminder) {
		reminderService.addReminder(reminder);
			return reminder;
	}
}


