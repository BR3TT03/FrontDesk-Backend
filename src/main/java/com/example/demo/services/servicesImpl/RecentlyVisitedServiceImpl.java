package com.example.demo.services.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RecentlyVisited;
import com.example.demo.repository.RecentlyVisitedRepository;
import com.example.demo.services.DatabaseService;
import com.example.demo.services.RecentlyVisitedService;

@Service
public class RecentlyVisitedServiceImpl implements RecentlyVisitedService {
	DatabaseService databaseService;

	public RecentlyVisitedServiceImpl(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@Override
	public List<RecentlyVisited> getRecentlyVisitedData() {
		// TODO Auto-generated method stub
		RecentlyVisitedRepository recentlyVisitedRepository = databaseService
				.getDaoClass(RecentlyVisitedRepository.class);

		return recentlyVisitedRepository.getRecentlyVisitedData();
	}

	@Override
	public void postRecenltyVisitedData(RecentlyVisited recentlyVisited) {
		// TODO Auto-generated method stub
		RecentlyVisitedRepository recentlyVisitedRepository = databaseService
				.getDaoClass(RecentlyVisitedRepository.class);

		recentlyVisitedRepository.postRecentlyVisitedData(recentlyVisited);

	}

}
