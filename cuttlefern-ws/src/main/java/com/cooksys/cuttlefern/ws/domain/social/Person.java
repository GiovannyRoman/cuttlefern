package com.cooksys.cuttlefern.ws.domain.social;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {

	@Id
	@SequenceGenerator(name="person_id_seq", sequenceName="person_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private City city;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="person_interests")
	private Set<Interest> interests;
	
	@JsonIgnore
	@ManyToMany(mappedBy="members", fetch=FetchType.LAZY)
	private Set<Group> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	
}
