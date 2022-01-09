package com.example.willitrain.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserRoute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String routename;
	private String start;
	private String end;
	private ArrayList<String> stops;
	private String preferredWeather;
	
	@ManyToOne
	private User user;
	
	
	
	public UserRoute(Long id, String routename, String start, String end, ArrayList<String> stops,
			String preferredWeather, User user) {
		super();
		this.id = id;
		this.routename = routename;
		this.start = start;
		this.end = end;
		this.stops = stops;
		this.preferredWeather = preferredWeather;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRoute(Long id, String routename, String start, String end, ArrayList<String> stops,
			String preferredWeather) {
		super();
		this.id = id;
		this.routename = routename;
		this.start = start;
		this.end = end;
		this.stops = stops;
		this.preferredWeather = preferredWeather;
	}

	public UserRoute() {
		super();
	}
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public ArrayList<String> getStops() {
		return stops;
	}

	public void setStops(ArrayList<String> stops) {
		this.stops = stops;
	}

	public String getPreferredWeather() {
		return preferredWeather;
	}

	public void setPreferredWeather(String preferredWeather) {
		this.preferredWeather = preferredWeather;
	}

	@Override
	public String toString() {
		return "UserRoutes [id=" + id + ", routename=" + routename + ", start=" + start + ", end=" + end + ", stops="
				+ stops + ", preferredWeather=" + preferredWeather + "]";
	}
	
	
	
	
}
