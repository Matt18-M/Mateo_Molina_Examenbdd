package com.krakedev.examen.vuelos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.services.VueloService;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService servicio;

    public VueloController(VueloService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Vuelo vuelo) {
        try {
            Vuelo creado = servicio.crear(vuelo);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el vuelo");
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<Vuelo> vuelos = servicio.listar();
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar los vuelos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            Vuelo vuelo = servicio.buscarPorId(id);

            if (vuelo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El vuelo con id " + id + " no fue encontrado");
            }
            return ResponseEntity.ok(vuelo);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar el vuelo");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
        try {
            Vuelo actualizado = servicio.actualizar(id, vuelo);

            if (actualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El vuelo con id " + id + " no existe");
            }
            return ResponseEntity.ok(actualizado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            boolean eliminado = servicio.eliminar(id);

            if (!eliminado) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se pudo eliminar, id no existe");
            }

            return ResponseEntity.ok("Vuelo eliminado con éxito");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar");
        }
    }

    // Consultas extras
    @GetMapping("/precio/menor")
    public ResponseEntity<?> buscarPorPrecio(@RequestParam double valor) {
        try {
            return ResponseEntity.ok(servicio.buscarPorPrecioMenor(valor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en búsqueda por precio");
        }
    }

    @GetMapping("/asientos/mayor")
    public ResponseEntity<?> buscarPorAsientos(@RequestParam int valor) {
        try {
            return ResponseEntity.ok(servicio.buscarPorAsientosMayor(valor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en búsqueda por asientos");
        }
    }
}