
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClientInfo;
import com.example.demo.services.ClientInfoService;

@CrossOrigin(origins = "*")
@RestController
public class TrashController {
	@Autowired 
	ClientInfoService clientInfoService;
	
	@GetMapping("/trash")
	public List<ClientInfo> getClientInfoFromTrash(){
		return clientInfoService.getClientInfoFromTrash();
	}
	@DeleteMapping("/deleteFromTrash/{id}")
	public String deleteFromTrash(@PathVariable("id") List<Integer> id) {
		boolean success = true;
		for(int clientId : id) {
			success = clientInfoService.deleteFromTrash(clientId);
		}
		if(success) {
			return "Successfully deleted records from trash";
		}
		return "Error while deleting!!" ;
	}
	
	@PostMapping("/restoreFromTrash/{id}")
	public String restoreFomTrash(@PathVariable("id") List<Integer> id) {
		for(int clientId:id) {
		clientInfoService.restoreFomTrash(clientId);
		}
		return "Successfully restored from trash!!";
		
	}


}
