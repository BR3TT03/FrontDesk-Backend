package com.example.demo.services;

import java.util.List;

import com.example.demo.model.ClientInfo;

public interface ClientInfoService {
	public List<ClientInfo> getClientInfo();
	public void insertClientInfo(ClientInfo clientInfo);
}
