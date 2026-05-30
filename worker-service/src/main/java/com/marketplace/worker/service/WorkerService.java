package com.marketplace.worker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.worker.dto.WorkerRequest;
import com.marketplace.worker.entity.Worker;
import com.marketplace.worker.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	
	public Worker registerWorker(WorkerRequest request) {
		
		Worker worker=Worker.builder()
				.name(request.getName())
				.email(request.getEmail())
				.phone(request.getPhone())
				.city(request.getCity())
				.category(request.getCategory())
				.experience(request.getExperience())
				.rating(0.0)
				.build();
		
		return workerRepository.save(worker);
						
	}
	
	public List<Worker> getAllWorkers(){
		
		return workerRepository.findAll();
	}
	
	public Worker getWorker(Long id) {
		
		return workerRepository.findById(id)
				.orElseThrow(() -> 
				  new RuntimeException("Worker Not Found"));
	}
	
	public List<Worker> getWorkersByCity(String city){
		
		return workerRepository.findByCity(city);
	}
	
	public List<Worker> getWorkersByCategory(String category){
		
		return workerRepository.findByCategory(category);
	}

}
