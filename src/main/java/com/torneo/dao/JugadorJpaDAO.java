package com.torneo.dao;

import com.torneo.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("jugadorJpaDAO")
public class JugadorJpaDAO implements IJugadorDAO {

    @Autowired
    private JugadorJpaRepository repository;

    @Override
    public List<Jugador> findAll() {
        return repository.findAll();
    }

    @Override
    public Jugador findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Jugador jugador) {
        repository.save(jugador);
    }

    @Override
    public void update(Jugador jugador) {
        repository.save(jugador);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}