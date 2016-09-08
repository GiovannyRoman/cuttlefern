package com.cooksys.cuttlefern.ws.domain.interest;

import java.util.List;

public interface InterestService {

	Interest create(Interest interest);

	List<Interest> index();

	Interest read(Integer id);

	Interest update(Integer id, Interest interestToUpdate);

	Interest delete(Integer id);

}
