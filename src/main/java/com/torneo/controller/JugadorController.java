package com.torneo.controller;

import com.torneo.model.Jugador;
import com.torneo.service.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@Tag(name = "Jugadores", description = "API para gestión de jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    @Operation(summary = "Obtener todos los jugadores")
    public ResponseEntity<List<Jugador>> getAll() throws SQLException {
        return ResponseEntity.ok(jugadorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener jugador por ID")
    public ResponseEntity<Jugador> getById(@PathVariable int id) throws SQLException {
        Jugador jugador = jugadorService.obtenerPorId(id);
        if (jugador == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(jugador);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo jugador")
    public ResponseEntity<String> create(@RequestBody Jugador jugador) throws SQLException {
        jugadorService.crear(jugador);
        return ResponseEntity.ok("Jugador creado exitosamente");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un jugador")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Jugador jugador) throws SQLException {
        jugador.setId(id);
        jugadorService.actualizar(jugador);
        return ResponseEntity.ok("Jugador actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un jugador")
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
        jugadorService.eliminar(id);
        return ResponseEntity.ok("Jugador eliminado exitosamente");
    }
}