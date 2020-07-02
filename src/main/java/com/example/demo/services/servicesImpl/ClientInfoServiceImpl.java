package com.example.demo.services.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ClientInfo;
import com.example.demo.repository.ClientInfoRepository;
import com.example.demo.services.ClientInfoService;
import com.example.demo.services.DatabaseService;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

	DatabaseService databaseService;
	
	public ClientInfoServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}

	@Override
	public List<ClientInfo> getClientInfo() {
		// TODO Auto-generated method stub
		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
		return clientInfoRepository.getClientInfo();
	}

	@Override
	public void insertClientInfo(ClientInfo clientInfo) {
		// TODO Auto-generated method stub
		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
		clientInfoRepository.insertClientInfo(clientInfo);
	}

}
