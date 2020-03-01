package com.example.msscbeerservice.msscbeerservice.domain;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID id;
	
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	private Date lastModifiedDate;
	
	private String beerName;
	private String beerStyle;
	
	@Column(unique = true)
	private Long upc;
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
}
