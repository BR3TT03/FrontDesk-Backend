package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/clientInfo")
	public List<ClientInfo> getClientInfoByStatus(
			@RequestParam(name ="status", required=false) String status,
			@RequestParam(name="order" , required=false, defaultValue="DESC") String order,
			@RequestParam(name="page") int page
			)
	{ 	
		return clientInfoService.getClientInfoByStatus((page-1)*10,status,order);
	}
	
	@GetMapping("/totalPages")
	public int getTotalPages() {
		int totalPage = clientInfoService.getTotalPages();
		if(totalPage%10!=0) {
			totalPage = (int)(totalPage/10) + 1;
			return totalPage;
		}
		
		return (totalPage/10);
		
	}

	@PostMapping("/clientInfo")
	public ClientInfo insertClientInfo(@RequestBody ClientInfo clientInfo) {
		clientInfoService.insertClientInfo(clientInfo);
		return clientInfo;
	}
}
