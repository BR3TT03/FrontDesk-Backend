package com.example.demo.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reminder;

@Repository
public interface ReminderRepository {
	@SqlQuery("SELECT * FROM Reminder")
	@RegisterBeanMapper(Reminder.class)
	public List<Reminder> getReminders();

	@SqlUpdate("INSERT INTO Reminder (task,date,status) VALUES (:task,:date,:status)")
	public void addReminder(@BindBean Reminder reminder);

}
