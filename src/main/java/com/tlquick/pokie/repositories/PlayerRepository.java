package com.tlquick.pokie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlquick.pokie.models.Player;

@Repository // all subclasses access database
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}

