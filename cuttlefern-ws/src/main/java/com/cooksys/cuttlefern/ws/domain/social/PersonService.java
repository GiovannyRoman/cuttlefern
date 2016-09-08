package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;

public interface PersonService {

	Person create(Person person);

	List<Person> index();

	Person read(Integer id);

	Person update(Integer id, Person personToUpdate);

	Person delete(Integer id);

	Set<Interest> readInterests(Integer id);

	Set<Interest> putInterests(Integer id,Set<Interest> interests);

	Interest deleteInterests(Integer id,Integer interest_id);

	Set<Group> readGroups(Integer id);

	Set<Group> putGroups(Integer id, Set<Group> groups);

	Group deleteGroups(Integer id, Integer group_id);

}
