package com.marketplace.worker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.worker.dto.WorkerRequest;
import com.marketplace.worker.entity.Worker;
import com.marketplace.worker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	
	@PostMapping("/register")
	public Worker registerWorker(@RequestBody WorkerRequest request) {
		
		return workerService.registerWorker(request);
	}
	
	@GetMapping("/getall")
	public List<Worker> getAllWorkers(){
		
		return workerService.getAllWorkers();
	}
	
	@GetMapping("/{id}")
	public Worker getWorker(@PathVariable Long id) {
		
		return workerService.getWorker(id);
	}
	
	@GetMapping("/city/{city}")
	public List<Worker> getWorkersByCity(@PathVariable String city){
		
		return workerService.getWorkersByCity(city);
	}
	
	@GetMapping("/category/{category}")
	public List<Worker> getWorkersByCategory(@PathVariable String category){
		
		return workerService.getWorkersByCategory(category);
	}

}
