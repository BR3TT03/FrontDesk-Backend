package com.example.demo.services.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Reminder;
import com.example.demo.repository.ReminderRepository;
import com.example.demo.services.DatabaseService;
import com.example.demo.services.ReminderService;

@Service
public class ReminderServiceImpl implements ReminderService {
	DatabaseService databaseService;

	public ReminderServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}

	@Override
	public List<Reminder> getReminders() {
		// TODO Auto-generated method stub
		ReminderRepository reminderRepository = databaseService.getDaoClass(ReminderRepository.class);
		return reminderRepository.getReminders();
	}
	
	
	

}
