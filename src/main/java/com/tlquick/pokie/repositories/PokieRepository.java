package com.tlquick.pokie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlquick.pokie.models.Pokie;

@Repository // all subclasses access database
public interface PokieRepository extends JpaRepository<Pokie, Integer> {
	Optional<Pokie> findFirstByOrderByIdAsc();
}
