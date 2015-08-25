package net.rmj.league.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "League")
public class League implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String leagueName;
	private int weeks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public int getWeeks() {
		return weeks;
	}
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	
	
}
