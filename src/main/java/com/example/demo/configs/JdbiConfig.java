package com.example.demo.configs;


import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JdbiConfig {

	/**
	 * Conenction pool bean configuration....
	 * @return
	 */
	@Bean
	public HikariDataSource hikariDatasource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		//RemoteMySql
//		 hikariConfig.setUsername("2JexZAJXeG");
//		 hikariConfig.setPassword("hdojRSzwXD"); 
//		 hikariConfig.setJdbcUrl("jdbc:mysql://remotemysql.com:3306/2JexZAJXeG?autoReconnect=true&serverTimezone=UTC");
//		 return new HikariDataSource(hikariConfig); 
		
		//LocalHost
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/FrontDesk?autoReconnect=true&serverTimezone=UTC");
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return new HikariDataSource(hikariConfig);
	}
	
	
	/**
	 * Configuration for @Transactional support
	 * @param datasource
	 * @return
	 */
	@Bean 
	public PlatformTransactionManager platformTransactionManager(HikariDataSource datasource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(datasource);
		return transactionManager;
	}
	
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSourceProxy(HikariDataSource datasource) {
		TransactionAwareDataSourceProxy transactionAwareProxy = new TransactionAwareDataSourceProxy(datasource);
		return transactionAwareProxy;
	}
	
	
	/**
	 * Configuration for jdbi 
	 */
	@Bean
	public Jdbi jdbiBean(TransactionAwareDataSourceProxy datasource) {
		Jdbi jdbi = Jdbi.create(datasource);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}
}
