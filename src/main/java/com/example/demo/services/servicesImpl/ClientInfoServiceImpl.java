package com.example.demo.services.servicesImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClientInfo;
import com.example.demo.repository.ClientInfoRepository;
import com.example.demo.services.ClientInfoService;
import com.example.demo.services.DatabaseService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

	DatabaseService databaseService;
	
	
	public ClientInfoServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}
	
	 /*
				 * // public List<ClientInfo> getClientInfo(int page) { // // TODO
				 * Auto-generated method stub // ClientInfoRepository clientInfoRepository =
				 * databaseService.getDaoClass(ClientInfoRepository.class); // return
				 * clientInfoRepository.getClientInfoDESc(page); // }
				 */
	@Override
	public List<ClientInfo> getClientInfoByStatus(int page,String status,String order) {
//		System.out.println("page:"+page+" status "+status+" order "+order);
		// TODO Auto-generated method stub
		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
		
		if(status==null && order.equalsIgnoreCase("ASC")) {
//			System.out.println("in asc");
			return clientInfoRepository.getClientInfoASC(page);
		}
		else if(status==null && order==null || status==null && order.equalsIgnoreCase("DESC")) {
//			System.out.println("null");
			return clientInfoRepository.getClientInfoDESC(page);
		}
		else if(order.equalsIgnoreCase("ASC") && status!=null) {
//			System.out.println("hey");
			return clientInfoRepository.getClientInfoByStatusASC(page, status, order);
		}
		
		else if((order.equalsIgnoreCase("DESC") && status!=null) || (order==null && status!=null	)) {
//			System.out.println("desc");
		return clientInfoRepository.getClientInfoByStatusDESC(page, status, order);
		}
		System.out.println("hey end");
		return null;
	}

	@Override
	public void insertClientInfo(ClientInfo clientInfo) {
		// TODO Auto-generated method stub
		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
		clientInfoRepository.insertClientInfo(clientInfo);
	}

	@Override
	public int getTotalPages() {
		// TODO Auto-generated method stub
		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
		return clientInfoRepository.getTotalPages();
	}

}
