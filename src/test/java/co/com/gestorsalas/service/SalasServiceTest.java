package co.com.gestorsalas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.gestorsalas.entity.Sala;
import co.com.gestorsalas.repository.SalasRepository;

@RunWith(MockitoJUnitRunner.class)
public class SalasServiceTest {
	
	@Mock
	private SalasRepository salasRepository;
	private Sala sala;
	
	@Before
	public void init() {	
		sala = Sala.builder().capacidad(50).horaDisponible(20).id("1234567")
				.nombre("Sala1").piso(2).build();
	}
	
	@Test
	public void findByIdOkTest() {
		// Arrange
		SalasService salasService = new SalasService(salasRepository);
		
		// Act
		when(salasRepository.findById("12345")).thenReturn(Optional.of(sala));
		Optional<Sala> salaRS = salasService.findById("12345");
		
		// Assert
		assertEquals(50, salaRS.get().getCapacidad());
	}

}
