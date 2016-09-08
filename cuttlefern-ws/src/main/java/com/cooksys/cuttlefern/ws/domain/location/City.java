package com.cooksys.cuttlefern.ws.domain.location;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"state_id", "name"}))
public class City {
	
	@Id
	@SequenceGenerator(name="city_id_seq", sequenceName="city_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="city_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="state_id") //State is not a column type. This is the column that represents a join between entity, not contains the entity
	private State state;
	
	@JsonIgnore
	@OneToMany(mappedBy="city", fetch=FetchType.LAZY)
	private Set<Person> people;
	
	@JsonIgnore
	@OneToMany(mappedBy="city", fetch=FetchType.LAZY)
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	
	
}
