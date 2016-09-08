package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;

public interface GroupService {

	Group create(Group group);

	List<Group> index();

	Group read(Integer id);

	Group update(Integer id, Group groupToUpdate);

	Group delete(Integer id);

	Interest getInterest(Integer id);

	Interest putInterest(Integer id, Interest interest);

	City getCity(Integer id);

	City putCity(Integer id, City city);

	Set<Person> getMembers(Integer id);

	Set<Person> putMembers(Integer id, Set<Person> members);

	Person deleteMembers(Integer id, Integer person_id);

}
