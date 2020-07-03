package com.example.demo.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClientInfo;

@Repository
public interface ClientInfoRepository {
	@SqlQuery("SELECT * FROM ClientInfo LIMIT 10,:page")
	@RegisterBeanMapper(ClientInfo.class)
	public List<ClientInfo> getClientInfo(@Bind int page);

	@SqlUpdate("INSERT INTO ClientInfo (name,academic,status,email,phone,weight,address,age,date,remark,height,gender,maritalStatus) VALUES (:name,:academic,:status,:email,:phone,:weight,:address,:age,:date,:remark,:height,:gender,:maritalStatus)")
	public void insertClientInfo(@BindBean ClientInfo clientInfo);
	
	@SqlQuery("SELECT COUNT(*) FROM ClientInfo")
	public int getTotalPages();
}
