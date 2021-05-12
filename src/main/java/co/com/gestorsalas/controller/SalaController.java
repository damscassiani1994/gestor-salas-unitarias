package co.com.gestorsalas.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.gestorsalas.entity.Sala;
import co.com.gestorsalas.service.SalasService;

@RestController
@RequestMapping("salas")
public class SalaController {
	
	private SalasService salaServices;
	
	public SalaController(SalasService salaServices) {
		this.salaServices = salaServices;
	}
	
	@GetMapping("/prueba")
	public ResponseEntity<String> prueba() {
		return ResponseEntity.ok("Hola Mundo");
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Sala>> getSalas() {
		return ResponseEntity.ok(salaServices.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sala> getSalas(@PathVariable String id) {
		Optional<Sala> salaRS = salaServices.findById(id);
		if (salaRS.isPresent()) {
			return ResponseEntity.ok(salaRS.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/name/{nombre}")
	public ResponseEntity<Sala> getByName(@PathVariable String nombre) {
		Optional<Sala> salaRS = salaServices.finByName(nombre);
		if (salaRS.isPresent()) {
			return ResponseEntity.ok(salaRS.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Sala> save(@RequestBody Sala sala) {
		return ResponseEntity.ok(salaServices.save(sala).get());
	}
	
	@DeleteMapping("/delete-id/{id}")
	public ResponseEntity<Sala> deleteById(@PathVariable String id) {
		Optional<Sala> salaRS = salaServices.deleteById(id);
		if (salaRS.isPresent()) {
			return ResponseEntity.ok(salaRS.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/deletes")
	public ResponseEntity<String> deleteAll() {
		Long registrosEliminados = salaServices.deleteAll();
		if (registrosEliminados == 0) return ResponseEntity.ok("No se encontraron salas a eliminar");
		return ResponseEntity.ok("Se eliminaron " + registrosEliminados + " salas");
	}
	
}
