package co.com.gestorsalas.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.com.gestorsalas.entity.Sala;
import co.com.gestorsalas.service.SalasService;

@RunWith(SpringRunner.class)
@WebMvcTest(SalaController.class)
public class SalaControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SalasService salaService;
	
	Sala sala;
	
	@Before
	public void init() {
		sala = Sala.builder().capacidad(50).horaDisponible(20).id("1234567")
				.nombre("Sala1").piso(2).build();
	}
	
	@Test
	public void getSalaPorIdOkTest() throws Exception {
		when(salaService.findById("12345")).thenReturn(Optional.of(sala));
		this.mockMvc.perform(get("/salas/12345").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
}
