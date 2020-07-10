package com.example.demo.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.OrderComparator;

import com.example.demo.model.ClientInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public interface ClientInfoService {
//	public List<ClientInfo> getClientInfo(int page);
	public List<ClientInfo> getClientInfoByStatus(int page, String status, String order, String nameFilter,
			String days);

	public void insertClientInfo(ClientInfo clientInfo);

//	public int getTotalPages();
	public boolean deleteClientInfoById(int id);

	public boolean updateClientInfo(ClientInfo existingData, int id);

	public int existsById(int id);

	public ClientInfo getClientInfoById(int id);

	public int getTotalPagesByStatus(String status);

	public List<ClientInfo> getClientInfoByField(String key, String value);
	public boolean deleteFromTrash(int id);

	/**
	 * @param id
	 * @return
	 */
	public boolean restoreFomTrash(int id);

	/**
	 * @return
	 */
	public List<ClientInfo> getClientInfoFromTrash();
}
