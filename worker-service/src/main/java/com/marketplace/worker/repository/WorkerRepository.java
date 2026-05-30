package com.marketplace.worker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.worker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	List<Worker> findByCity(String city);
	
	List<Worker> findByCategory(String category);

}
