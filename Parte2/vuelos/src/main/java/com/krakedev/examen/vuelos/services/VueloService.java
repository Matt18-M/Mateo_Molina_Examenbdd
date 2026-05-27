package com.krakedev.examen.vuelos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

@Service
public class VueloService {

	private final VueloRepository repository;

	public VueloService(VueloRepository repository) {
		this.repository = repository;
	}

	public Vuelo crear(Vuelo vuelo) {
		return repository.save(vuelo);
	}

	public List<Vuelo> listar() {
		return repository.findAll();
	}

	public Vuelo buscarPorId(Integer id) {
		Optional<Vuelo> resultado = repository.findById(id);
		return resultado.orElse(null);
	}

	public Vuelo actualizar(Integer id, Vuelo vueloActualizado) {

		Vuelo vuelo = buscarPorId(id);

		if (vuelo == null) {
			return null;
		}

		vuelo.setCodigo(vueloActualizado.getCodigo());
		vuelo.setPrecioBoleto(vueloActualizado.getPrecioBoleto());
		vuelo.setAsientosDisponibles(vueloActualizado.getAsientosDisponibles());
		vuelo.setDestino(vueloActualizado.getDestino());
		return repository.save(vuelo);
	}

	public boolean eliminar(Integer id) {

		Vuelo vuelo = buscarPorId(id);

		if (vuelo == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}

	// Métodos adicionales para el examen
	public List<Vuelo> buscarPorPrecioMenor(double precio) {
		return repository.findByPrecioBoletoLessThan(precio);
	}

	public List<Vuelo> buscarPorAsientosMayor(int asientos) {
		return repository.findByAsientosDisponiblesGreaterThan(asientos);
	}
}