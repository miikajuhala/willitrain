package com.example.willitrain.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Frame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String name;
	private String player1;
	private String player2;
	private Integer player1Score;
	private Integer player2Score;
	private Integer reds;
	private Boolean black;  
	private Boolean pink;  
	private Boolean blue;  
	private Boolean green;  
	private Boolean brown;  
	private Boolean yellow;  
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	
	


	public Frame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Frame(Long id, String name, String player1, String player2, User user) {
		super();
		this.id = id;
		this.name = name;
		this.player1 = player1;
		this.player2 = player2;
		this.user = user;
	}




	public Frame(Long id, String name, String player1, String player2, Integer player1Score, Integer player2Score,
			Integer reds, Boolean black, Boolean pink, Boolean blue, Boolean green, Boolean brown, Boolean yellow,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.player1 = player1;
		this.player2 = player2;
		this.player1Score = player1Score;
		this.player2Score = player2Score;
		this.reds = reds;
		this.black = black;
		this.pink = pink;
		this.blue = blue;
		this.green = green;
		this.brown = brown;
		this.yellow = yellow;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPlayer1() {
		return player1;
	}


	public void setPlayer1(String player1) {
		this.player1 = player1;
	}


	public String getPlayer2() {
		return player2;
	}


	public void setPlayer2(String player2) {
		this.player2 = player2;
	}


	public Integer getPlayer1Score() {
		return player1Score;
	}


	public void setPlayer1Score(Integer player1Score) {
		this.player1Score = player1Score;
	}


	public Integer getPlayer2Score() {
		return player2Score;
	}


	public void setPlayer2Score(Integer player2Score) {
		this.player2Score = player2Score;
	}


	public Integer getReds() {
		return reds;
	}


	public void setReds(Integer reds) {
		this.reds = reds;
	}


	public Boolean getBlack() {
		return black;
	}


	public void setBlack(Boolean black) {
		this.black = black;
	}


	public Boolean getPink() {
		return pink;
	}


	public void setPink(Boolean pink) {
		this.pink = pink;
	}


	public Boolean getBlue() {
		return blue;
	}


	public void setBlue(Boolean blue) {
		this.blue = blue;
	}


	public Boolean getGreen() {
		return green;
	}


	public void setGreen(Boolean green) {
		this.green = green;
	}


	public Boolean getBrown() {
		return brown;
	}


	public void setBrown(Boolean brown) {
		this.brown = brown;
	}


	public Boolean getYellow() {
		return yellow;
	}


	public void setYellow(Boolean yellow) {
		this.yellow = yellow;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Frame [id=" + id + ", name=" + name + ", player1=" + player1 + ", player2=" + player2
				+ ", player1Score=" + player1Score + ", player2Score=" + player2Score + ", reds=" + reds + ", black="
				+ black + ", pink=" + pink + ", blue=" + blue + ", green=" + green + ", brown=" + brown + ", yellow="
				+ yellow + ", user=" + user + "]";
	}

	
	


	
	
	
	
}
