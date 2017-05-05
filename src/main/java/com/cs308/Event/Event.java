package com.cs308.Event;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String info;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}	
}
 