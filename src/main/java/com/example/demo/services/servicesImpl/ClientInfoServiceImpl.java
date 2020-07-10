package com.example.demo.services.servicesImpl;

import java.lang.reflect.Field;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.OrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClientInfo;
import com.example.demo.repository.ClientInfoRepository;
import com.example.demo.services.ClientInfoService;
import com.example.demo.services.DatabaseService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

	DatabaseService databaseService;
	ClientInfoRepository clientInfoRepository;

	public ClientInfoServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
		this.clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
	}

	/*
	 * // public List<ClientInfo> getClientInfo(int page) { // // TODO
	 * Auto-generated method stub // ClientInfoRepository clientInfoRepository =
	 * databaseService.getDaoClass(ClientInfoRepository.class); // return
	 * clientInfoRepository.getClientInfoDESc(page); // }
	 */
	@Override
	public List<ClientInfo> getClientInfoByStatus(int page, String status, String order, String nameFilter,
			String days) {
		if(days.equalsIgnoreCase("all")) days = "-1";
		int Days = Integer.parseInt(days);
//		LocalDate endDate;
//		LocalDate startDate = LocalDate.now();
//		endDate = startDate;
//		startDate = startDate.minusDays(Days);
//		
		if (status.equalsIgnoreCase("all")) {
			status = "";
		}
		if (order.equalsIgnoreCase("asc")) {
			return clientInfoRepository.getClientInfoByStatusASC(page, status, order, nameFilter, Days);
		} else if (order.equalsIgnoreCase("desc")) {
			return clientInfoRepository.getClientInfoByStatusDESC(page, status, order, nameFilter, Days);

		}
//		if (status == null && order.equalsIgnoreCase("ASC")) {
//			return clientInfoRepository.getClientInfoASC(page,startDate,endDate);
//		} else if (status == null && order == null || status == null && order.equalsIgnoreCase("DESC")) {
//			return clientInfoRepository.getClientInfoDESC(page,startDate,endDate);
//		} else if (order.equalsIgnoreCase("ASC") && status != null) {
//			return clientInfoRepository.getClientInfoByStatusASC(page, status, order,startDate,endDate);
//		}
//
//		else if ((order.equalsIgnoreCase("DESC") && status != null) || (order == null && status != null)) {
//			return clientInfoRepository.getClientInfoByStatusDESC(page, status, order,nameFilter,startDate,endDate);
//		}
		return null;
	}

	@Override
	public void insertClientInfo(ClientInfo clientInfo) {
		clientInfoRepository.insertClientInfo(clientInfo);
	}

//	@Override
//	public int getTotalPages() {
//		// TODO Auto-generated method stub
//		ClientInfoRepository clientInfoRepository = databaseService.getDaoClass(ClientInfoRepository.class);
//		return clientInfoRepository.getTotalPages();
//	}

	@Override
	public boolean deleteClientInfoById(int id) {
		boolean status;
		clientInfoRepository.moveToTrash(id);
		status = clientInfoRepository.deleteClientInfoById(id);
		return status;

	}

	@Override
	public boolean updateClientInfo(ClientInfo clientInfo, int id) {
		return clientInfoRepository.updateClientInfo(clientInfo, id);

	}

	@Override
	public int existsById(int id) {
		try {
			return clientInfoRepository.existsById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}

	@Override
	public ClientInfo getClientInfoById(int id) {
		try {
			ClientInfo existing = clientInfoRepository.getClientInfoById(id);
			return existing;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public int getTotalPagesByStatus(String status) {
		if (status.equalsIgnoreCase("all")) {
			status = "";
			return clientInfoRepository.getTotalPagesByStatus(status);
		}
		return clientInfoRepository.getTotalPagesByStatus(status);
	}

	@Override
	public List<ClientInfo> getClientInfoByField(String key, String value) {
		return clientInfoRepository.getClientInfoByField(key, value);

	}

	public boolean deleteFromTrash(int id) {
		return clientInfoRepository.deleteFromTrash(id);
	}

	@Override
	public boolean restoreFomTrash(int id) {
		clientInfoRepository.restoreFromTrash(id);
		clientInfoRepository.deleteFromTrash(id);
		return true;
	}

	@Override
	public List<ClientInfo> getClientInfoFromTrash() {
		return clientInfoRepository.getClientInfoFromTrash();
	}
}
