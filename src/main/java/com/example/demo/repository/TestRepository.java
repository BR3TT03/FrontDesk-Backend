package com.example.demo.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TestModel;
@Repository
public interface TestRepository {
	@SqlQuery("SELECT * FROM test ORDER BY birthDate DESC")
	@RegisterBeanMapper(TestModel.class)
	public List<TestModel> getTestData();
	
	@SqlUpdate("INSERT INTO test (name,birthDate) VALUES (:name,:birthDate)")
	public void postTestData(@BindBean TestModel testModel);
}
