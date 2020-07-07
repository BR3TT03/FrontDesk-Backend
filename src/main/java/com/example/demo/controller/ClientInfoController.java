package com.example.demo.controller;

import java.lang.reflect.Field;
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

	/*
	 * @GetMapping("/clientInfo/{page}") public List<ClientInfo>
	 * getClientInfo(@PathVariable int page){ // int NoOfPages =
	 * clientInfoService.getClientInfo().size(); return
	 * clientInfoService.getClientInfo((page-1)*10); }
	 */

	@GetMapping("/totalPages")
	public int getTotalPages() {
		int totalPage = clientInfoService.getTotalPages();
		if (totalPage % 10 != 0) {
			totalPage = (int) (totalPage / 10) + 1;
			return totalPage;
		}

		return (totalPage / 10);

	}

	@GetMapping("/clientInfo")
	public List<ClientInfo> getClientInfoByStatus(@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "order", required = false, defaultValue = "DESC") String order,
			@RequestParam(name = "page") int page) {
		return clientInfoService.getClientInfoByStatus((page - 1) * 10, status, order);
	}

	@PostMapping("/clientInfo")
	public ClientInfo insertClientInfo(@RequestBody ClientInfo clientInfo) {
		clientInfoService.insertClientInfo(clientInfo);
		return clientInfo;
	}

	@DeleteMapping("/deleteClientInfo/{id}")
	public String deleteClientInfoById(@PathVariable List<Integer> id) {
		for (int clientId : id) {
			if (clientInfoService.existsById(clientId) == 1) 
			{
				clientInfoService.deleteClientInfoById(clientId);
			}
			else {
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
			clientInfo.forEach((k, v) -> {
				// use reflection to get field k on object and set it to value v
				// Change Claim.class to whatver your object is: Object.class
				Field field = ReflectionUtils.findField(ClientInfo.class, (String) k);
				System.out.println(field);// find field in the object class
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingData, v);
				// set given field for defined object to value V
			});

			clientInfoService.updateClientInfo(existingData, id);
			return "Successfully updated";
//		    claimService.saveOrUpdate(claim);
		}
		return "Client with clientId " + id + " does not exist";

	}
}
