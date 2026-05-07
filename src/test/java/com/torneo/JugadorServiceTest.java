package com.torneo;

import com.torneo.dao.IJugadorDAO;
import com.torneo.model.Jugador;
import com.torneo.service.JugadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JugadorServiceTest {

    @Mock
    private IJugadorDAO jugadorDAO;

    @InjectMocks
    private JugadorService jugadorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearConNombreVacio() throws SQLException {
        Jugador jugador = new Jugador(null, "", "srmacha", "luis@mail.com", "FIFA");

        jugadorService.crear(jugador);

        verify(jugadorDAO, times(1)).save(jugador);
    }



    @Test
    void testObtenerTodos() throws SQLException {
        List<Jugador> jugadores = Arrays.asList(
            new Jugador(1, "Luis", "srmacha", "luis@mail.com", "FIFA"),
            new Jugador(2, "Miguel", "miguelito", "miguel@mail.com", "Valorant")
        );
        when(jugadorDAO.findAll()).thenReturn(jugadores);

        List<Jugador> resultado = jugadorService.obtenerTodos();

        assertEquals(2, resultado.size());
        verify(jugadorDAO, times(1)).findAll();
    }

    
    @Test
    void testObtenerPorId() throws SQLException {
        Jugador jugador = new Jugador(1, "Luis", "srmacha", "luis@mail.com", "FIFA");
        when(jugadorDAO.findById(1)).thenReturn(jugador);

        Jugador resultado = jugadorService.obtenerPorId(1);

        assertNotNull(resultado);
        assertEquals("Luis", resultado.getNombre());
        verify(jugadorDAO, times(1)).findById(1);
    }

    @Test
    void testObtenerPorIdNoExiste() throws SQLException {
        when(jugadorDAO.findById(99)).thenReturn(null);

        Jugador resultado = jugadorService.obtenerPorId(99);

        assertNull(resultado);
    }

    @Test
    void testCrear() throws SQLException {
        Jugador jugador = new Jugador(null, "Luis", "srmacha", "luis@mail.com", "FIFA");

        jugadorService.crear(jugador);

        verify(jugadorDAO, times(1)).save(jugador);
    }

    @Test
    void testActualizar() throws SQLException {
        Jugador jugador = new Jugador(1, "Luis", "srmacha", "luis@mail.com", "FIFA");

        jugadorService.actualizar(jugador);

        verify(jugadorDAO, times(1)).update(jugador);
    }

    @Test
    void testEliminar() throws SQLException {
        jugadorService.eliminar(1);

        verify(jugadorDAO, times(1)).delete(1);
    }
}