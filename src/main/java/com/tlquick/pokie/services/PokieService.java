package com.tlquick.pokie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlquick.pokie.models.Pokie;
import com.tlquick.pokie.repositories.PokieRepository;

@Service // this class is a service component (bean)
public class PokieService {
	private final PokieRepository repository;

	@Autowired
	public PokieService(PokieRepository repository) {
		super();
		this.repository = repository;
	}

	public Optional<Pokie> getPokie() {
		return repository.findFirstByOrderByIdAsc();

	}

}
