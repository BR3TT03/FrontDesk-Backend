package com.example.demo.services;

import java.sql.Date;
import java.util.List;

import org.springframework.core.OrderComparator;

import com.example.demo.model.ClientInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public interface ClientInfoService {
	public List<ClientInfo> getClientInfoByFields(int page,String status,String orderBy);
	public void insertClientInfo(ClientInfo clientInfo);
	public int getTotalPages();
}
