package com.marketplace.worker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "workers")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Column(unique=true)
	private String email;
	private String phone;
	private String city;
	private String category;
	private Integer experience;
	private Double rating;

}
