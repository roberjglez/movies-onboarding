package com.rjgonzalez.moviesonboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rjgonzalez.moviesonboarding.entity.ActorEntity;

/**
 * Actor Repository
 * 
 * @author Roberto Jesus Gonzalez Carrato Pozo
 *
 */
@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {

}
