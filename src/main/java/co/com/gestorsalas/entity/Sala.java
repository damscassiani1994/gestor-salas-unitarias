
package co.com.gestorsalas.entity;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Sala {
	
	@Id
	private String id;
	private int piso;
	private int capacidad;
	private String nombre;
	private int horaDisponible;
}
