package com.turing.jpa.demo.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@Column
	String title;
	
	@Column
	Integer year;
	
	@Column
	String genre;
}
