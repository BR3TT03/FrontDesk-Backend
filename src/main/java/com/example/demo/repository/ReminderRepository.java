package com.example.demo.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reminder;

@Repository
public interface ReminderRepository {
	@SqlQuery("SELECT * FROM Reminder")
	@RegisterBeanMapper(Reminder.class)
	public List<Reminder> getReminders();

}
