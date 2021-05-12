package co.com.gestorsalas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.com.gestorsalas.entity.Sala;
import co.com.gestorsalas.repository.SalasRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SalasService {

	private SalasRepository salasRepository;

	public Optional<Sala> findById(String id) {
		return salasRepository.findById(id);
	}

	public Optional<Sala> finByName(String nombre) {
		return Optional.of(salasRepository.findByNombre(nombre));
	}

	public Optional<Sala> save(Sala sala) {
		return Optional.of(salasRepository.save(sala));
	}

	public List<Sala> findAll() {
		return salasRepository.findAll();
	}

	public Optional<Sala> deleteById(String id) {
		Optional<Sala> sala = findById(id);
		if (sala.isPresent()) {
			salasRepository.deleteById(sala.get().getId());
		}
		return sala;
	}

	public Long deleteAll() {
		Long cantidad = salasRepository.count();
		if (cantidad > 0) {
			salasRepository.deleteAll();
		}
		return cantidad;
	}
}
