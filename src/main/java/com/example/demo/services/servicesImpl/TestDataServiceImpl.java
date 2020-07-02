package com.example.demo.services.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.TestModel;
import com.example.demo.repository.TestRepository;
import com.example.demo.services.DatabaseService;
import com.example.demo.services.TestDataService;

@Service
public class TestDataServiceImpl implements TestDataService {
	DatabaseService dataBaseService;

	public TestDataServiceImpl(DatabaseService dataBaseService) {
		this.dataBaseService = dataBaseService;
	}

	@Override
	public List<TestModel> getTestData() {
		// TODO Auto-generated method stub
		TestRepository testRepository = dataBaseService.getDaoClass(TestRepository.class);
		return testRepository.getTestData();
	}

	@Override
	public void postTestData(TestModel testModel) {
		// TODO Auto-generated method stub
		TestRepository testRepository = dataBaseService.getDaoClass(TestRepository.class);
		testRepository.postTestData(testModel);
	}

}
