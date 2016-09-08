package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;

public interface StateService {

	State create(State state);

	List<State> index();

	State read(Integer id);

	State update(Integer id, State stateToUpdate);

	State delete(Integer id);

}
