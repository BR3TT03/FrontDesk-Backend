package com.example.demo.services;
import java.util.List;

import com.example.demo.model.TestModel;
public interface TestDataService {
	public List<TestModel> getTestData();

	public void postTestData(TestModel testModel);
}
