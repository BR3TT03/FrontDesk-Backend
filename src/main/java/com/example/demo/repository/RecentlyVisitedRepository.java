package com.example.demo.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RecentlyVisited;

@Repository
public interface RecentlyVisitedRepository {

	@SqlQuery("SELECT * FROM RecentlyVisited ORDER BY date DESC")
	@RegisterBeanMapper(RecentlyVisited.class)
	public List<RecentlyVisited> getRecentlyVisitedData();
	
	@SqlUpdate("INSERT INTO RecentlyVisited (name,view,remark,date) VALUES (:name,:view,:remark,:date)")
	public void postRecentlyVisitedData(@BindBean RecentlyVisited recentlyVisited);
}
