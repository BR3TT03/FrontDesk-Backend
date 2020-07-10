package com.example.demo.controller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClientInfo;
import com.example.demo.services.ClientInfoService;

@CrossOrigin(origins = "*")
@RestController
public class ClientInfoController {
	@Autowired
	ClientInfoService clientInfoService;

	@GetMapping
	public String homePage() {
		return "Welcome to FrontDesk Api";
	}

	@GetMapping("/totalPages")
	public int getTotalPagesByStatus(@RequestParam(name = "status") String status) {
		int totalPage = 1;
		totalPage = clientInfoService.getTotalPagesByStatus(status);
		if (totalPage % 10 != 0) {
			totalPage = (int) (totalPage / 10) + 1;
			return totalPage;
		}

		return (totalPage / 10);

	}

	@GetMapping("/clientInfo")
	public List<ClientInfo> getClientInfoByStatus(
			@RequestParam(name = "status", required = false, defaultValue = "") String status,
			@RequestParam(name = "order", required = false, defaultValue = "DESC") String order,
			@RequestParam(name = "page") int page,
			@RequestParam(name = "nameFilter", required = false, defaultValue="") String nameFilter,
			@RequestParam(name="days",required=false,defaultValue="0") String days
			) 
			
	{
		return clientInfoService.getClientInfoByStatus((page - 1) * 10, status, order, nameFilter, days);
	}

	@PostMapping("/insertClientInfo")
	public ClientInfo insertClientInfo(@RequestBody ClientInfo clientInfo) {
		clientInfoService.insertClientInfo(clientInfo);
		return clientInfo;
	}

	@DeleteMapping("/deleteClientInfo/{id}")
	public String deleteClientInfoById(@PathVariable List<Integer> id) {
		for (int clientId : id) {
			if (clientInfoService.existsById(clientId) == 1) {
				clientInfoService.deleteClientInfoById(clientId);
			} else {
				return "Client Id " + clientId + " does not exists!";
			}
		}
		return "Successfully deleted!";
	}

	@PatchMapping("/updateClientInfo/{id}")
	public String updateClientInfo(@RequestBody Map<Object, Object> clientInfo, @PathVariable("id") int id) {

		if (clientInfoService.existsById(id) == 1) {
			System.out.println("before null pointer exception");
			ClientInfo existingData = clientInfoService.getClientInfoById(id);
			System.out.println("After null pointer exception");
			clientInfo.forEach((k, v) -> {
				Field field = ReflectionUtils.findField(ClientInfo.class, (String) k);
				System.out.println("#######Field: " + field.getName() + "############# " + k);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingData, v);
			});

			clientInfoService.updateClientInfo(existingData, id);
			return "Successfully updated";
//		    claimService.saveOrUpdate(claim);
		}
		return "Client with clientId " + id + " does not exist";

	}

	/*
	 * @GetMapping("/clientInfo/{page}") public List<ClientInfo>
	 * getClientInfo(@PathVariable int page){ // int NoOfPages =
	 * clientInfoService.getClientInfo().size(); return
	 * clientInfoService.getClientInfo((page-1)*10); }
	 */

//	@GetMapping("clientInfo/totalPages")
//	public int getTotalPages() {
//		int totalPage = clientInfoService.getTotalPages();
//		if (totalPage % 10 != 0) {
//			totalPage = (int) (totalPage / 10) + 1;
//			return totalPage;
//		}
//
//		return (totalPage / 10);
//
//	}

//	@GetMapping("/clientInfoByField")
//	public List<ClientInfo> getClientInfoByField(@RequestParam Map<Object,Object> field){
//		String[] columnName= {"null"};	
//		String[] value= {"null"};
//		field.forEach((k, v) -> {
//			columnName[0]=(String)k;
//			value[0] = (String)v;
//		});
//		
//		return clientInfoService.getClientInfoByField(columnName[0],value[0]);
//	}

}
