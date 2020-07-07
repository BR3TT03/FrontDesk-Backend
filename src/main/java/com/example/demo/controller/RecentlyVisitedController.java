//package com.example.demo.controller;
//
//public class RecentlyVisitedController {
//
//}
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RecentlyVisited;
import com.example.demo.services.RecentlyVisitedService;

@CrossOrigin(origins = "*")
@RestController
public class RecentlyVisitedController {

	@Autowired
	RecentlyVisitedService recentlyVisitedService;

	@GetMapping("/recentlyVisited")
	public List<RecentlyVisited> getRecentlyVisitedData() {
		return recentlyVisitedService.getRecentlyVisitedData();
	}

	@PostMapping("/recentlyVisited")
	public RecentlyVisited postRecentlyVisitedData(@RequestBody RecentlyVisited recentlyVisited) {
		recentlyVisitedService.postRecenltyVisitedData(recentlyVisited);
		return recentlyVisited;
	}

}
