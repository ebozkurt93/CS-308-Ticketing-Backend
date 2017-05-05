package com.cs308.Event.EventMedia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventmedia")
public class EventMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String imageUrl1;
	@Column(nullable = false)
	private String imageUrl2;
	@Column(nullable = false)
	private String videoUrl;

	
	

}
