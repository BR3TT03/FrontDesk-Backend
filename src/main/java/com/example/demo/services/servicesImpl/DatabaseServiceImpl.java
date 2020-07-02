package com.example.demo.services.servicesImpl;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.services.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	private final Logger LOGGER = LoggerFactory.getLogger(DatabaseServiceImpl.class);
	private Jdbi jdbi;
	public DatabaseServiceImpl(Jdbi jdbi) {
		this.jdbi = jdbi;
	}


	@Override
	public <T> T getDaoClass(Class<T> daoClass) {
		try {
			if(jdbi != null) {
				return jdbi.onDemand(daoClass);
			} 
			
			throw new NullPointerException("jdbi object isnot initialized...");
		} catch(Exception ex) {
			LOGGER.info(ex.getMessage());
		}
		return null;
	}
}
