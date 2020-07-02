package com.example.demo.services;

import java.util.List;

import com.example.demo.model.RecentlyVisited;

public interface RecentlyVisitedService {
	public List<RecentlyVisited> getRecentlyVisitedData();
	public void postRecenltyVisitedData(RecentlyVisited recentlyVisited);
}
