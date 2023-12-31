package com.springboot.main.myproj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.myproj.exception.InvalidIdException;
import com.springboot.main.myproj.model.BusOperator;
import com.springboot.main.myproj.model.Executive;
import com.springboot.main.myproj.repository.ExecutiveRepository;

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	public Executive insert(Executive executive) {
		return executiveRepository.save(executive);
	}
	
		public Executive getById(int eid) throws InvalidIdException {
			Optional<Executive> optional = executiveRepository.findById(eid);
			if(!optional.isPresent())
				throw new InvalidIdException("boid invalid");
			return optional.get();
		}

}
