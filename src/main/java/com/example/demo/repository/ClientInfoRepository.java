package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClientInfo;

@Repository
public interface ClientInfoRepository {

//	@SqlQuery("SELECT * FROM ClientInfo ORDER BY createdAt DESC LIMIT 10 OFFSET :page")
//	@RegisterBeanMapper(ClientInfo.class)
//	public List<ClientInfo> getClientInfoDESC(@Bind int page,LocalDate startDate,LocalDate endDate);
//	
//	@SqlQuery("SELECT * FROM ClientInfo ORDER BY createdAt ASC LIMIT 10 OFFSET :page")
//	@RegisterBeanMapper(ClientInfo.class)
//	public List<ClientInfo> getClientInfoASC(@Bind int page,LocalDate startDate,LocalDate endDate);
//	
	@SqlQuery("SELECT COUNT(1) FROM ClientInfo WHERE id=:id")
	public int existsById(@Bind int id);

	@SqlQuery("SELECT * FROM ClientInfo WHERE id=:id")
	@RegisterBeanMapper(ClientInfo.class)
	public ClientInfo getClientInfoById(@Bind int id);

	@SqlQuery("SELECT * FROM ClientInfo WHERE (status LIKE CONCAT(:status,'%') AND "
			+ "IF(:Days = -1, createdAt <= CURRENT_DATE, createdAt>=CURRENT_DATE- :Days)"
			+ "AND name LIKE CONCAT('%',:nameFilter,'%')) "
			+ "ORDER BY createdAt DESC LIMIT 10 OFFSET :page")
	@RegisterBeanMapper(ClientInfo.class)
	public List<ClientInfo> getClientInfoByStatusDESC(@Bind int page, String status, String orderBy, String nameFilter,
			int Days);

	@SqlQuery("SELECT * FROM ClientInfo WHERE (status LIKE CONCAT(:status,'%') AND "
			+ "IF(:Days = -1, createdAt <= CURRENT_DATE, createdAt>=CURRENT_DATE- :Days)"
			+ "AND name LIKE CONCAT('%',:nameFilter,'%')) "
			+ "ORDER BY createdAt ASC LIMIT 10 OFFSET :page")
	@RegisterBeanMapper(ClientInfo.class)
	public List<ClientInfo> getClientInfoByStatusASC(@Bind int page, String status, String orderBy, String nameFilter,
			int Days);

	@SqlUpdate("INSERT INTO ClientInfo (name,academic,status,email,phone,weight,address,age,date,remark,height,gender,"
			+ "maritalStatus,createdAt) VALUES (:name,:academic,:status,:email,:phone,:weight,:address,:age,:date,:remark,:height,"
			+ ":gender,:maritalStatus,CURRENT_DATE)")
	public void insertClientInfo(@BindBean ClientInfo clientInfo);

	@SqlUpdate("DELETE FROM ClientInfo WHERE id=:id")
	public boolean deleteClientInfoById(@Bind int id);

//	@SqlQuery("SELECT COUNT(*) FROM ClientInfo")
//	public int getTotalPages();

	@SqlUpdate("UPDATE ClientInfo SET name =:name,academic=:academic,status=:status,email=:email,phone=:phone,weight=:weight,address=:address,"
			+ "age=:age,date=:date,remark=:remark,height=:height,gender=:gender,maritalStatus=:maritalStatus,createdAt=CURRENT_DATE WHERE id=:id")
	@RegisterBeanMapper(ClientInfo.class)
	public boolean updateClientInfo(@BindBean ClientInfo clientInfo, @Bind int id);

	@SqlQuery("SELECT COUNT(*) FROM ClientInfo where status LIKE CONCAT(:status,'%')")
	public int getTotalPagesByStatus(@Bind String status);

	@SqlQuery("SELECT * FROM ClientInfo WHERE :key=:value")
	@RegisterBeanMapper(ClientInfo.class)
	public List<ClientInfo> getClientInfoByField(String key, String value);
	
	@SqlUpdate("INSERT INTO Trash SELECT * FROM ClientInfo WHERE id = :id")
	public void moveToTrash(@Bind int id);
	
	@SqlUpdate("DELETE FROM Trash WHERE id = :id")
	public boolean deleteFromTrash(@Bind int id);
	
	@SqlUpdate("INSERT INTO ClientInfo SELECT * FROM Trash where id = :id ")
	public void restoreFromTrash(@Bind int id);

	@SqlQuery("SELECT * FROM Trash")
	@RegisterBeanMapper(ClientInfo.class)
	public List<ClientInfo> getClientInfoFromTrash();
}
