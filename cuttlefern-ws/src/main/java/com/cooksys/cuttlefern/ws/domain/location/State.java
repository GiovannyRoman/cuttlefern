package com.cooksys.cuttlefern.ws.domain.location;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class State {

	@Id
	@SequenceGenerator(name="state_id_seq", sequenceName="state_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="state_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="state", fetch=FetchType.LAZY) //@ManyToMany, @OneToMany are almost always LAZY
	private Set<City> cities;

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

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	
}
