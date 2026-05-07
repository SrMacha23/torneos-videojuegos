package com.torneo.dao;

import com.torneo.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorJpaRepository extends JpaRepository<Jugador, Integer> {
}