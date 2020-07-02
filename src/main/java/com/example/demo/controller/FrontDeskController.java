package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TestModel;
import com.example.demo.services.TestDataService;

@RestController
public class FrontDeskController {

	@Autowired
	TestDataService testDataService;

	@GetMapping
	public List<TestModel> getTestData() throws NullPointerException {
		return testDataService.getTestData();
	}

	@PostMapping
	public TestModel postTestData(@RequestBody TestModel testModel) {
		testDataService.postTestData(testModel);
		return testModel;
	}
}
