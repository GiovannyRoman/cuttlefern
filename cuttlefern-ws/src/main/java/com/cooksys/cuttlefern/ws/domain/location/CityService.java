package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;

public interface CityService {

	City create(City city);

	List<City> index();

	City read(Integer id);

	City update(Integer id, City cityToUpdate);

	City delete(Integer id);

	State readState(Integer id);

	State putState(Integer id, State state);

}
