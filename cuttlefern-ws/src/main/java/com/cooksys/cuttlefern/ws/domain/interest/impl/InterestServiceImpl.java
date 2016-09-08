package com.cooksys.cuttlefern.ws.domain.interest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestRepository;
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;

@Service
public class InterestServiceImpl implements InterestService {

	private final InterestRepository repo;

	@Autowired
	public InterestServiceImpl(InterestRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Interest create(Interest interest) {
		return this.repo.save(interest);
	}

	@Override
	public List<Interest> index() {
		return this.repo.findAll();
	}

	@Override
	public Interest read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Interest update(Integer id, Interest interestToUpdate) {
		interestToUpdate.setId(id);
		return this.repo.save(interestToUpdate);
	}

	@Override
	public Interest delete(Integer id) {
		Interest result = this.read(id);
		this.repo.delete(id);
		return result;
	}
}
