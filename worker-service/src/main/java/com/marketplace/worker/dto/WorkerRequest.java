package com.marketplace.worker.dto;

import lombok.Data;

@Data
public class WorkerRequest {
	
	private String name;
	private String email;
	private String phone;
	private String city;
	private String category;
	private Integer experience;

}
