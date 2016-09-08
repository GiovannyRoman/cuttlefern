package com.cooksys.cuttlefern.ws.domain.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateRepository;
import com.cooksys.cuttlefern.ws.domain.location.StateService;

@Service
public class StateServiceImpl implements StateService {

	private final StateRepository repo;

	@Autowired
	public StateServiceImpl(StateRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public State create(State state) {
		return this.repo.save(state);
	}

	@Override
	public List<State> index() {
		return this.repo.findAll();
	}

	@Override
	public State read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public State update(Integer id, State stateToUpdate) {
		stateToUpdate.setId(id);
		return this.repo.save(stateToUpdate);
	}

	@Override
	public State delete(Integer id) {
		State result = this.read(id);
		this.repo.delete(id);
		return result;
	}
	
	
}
