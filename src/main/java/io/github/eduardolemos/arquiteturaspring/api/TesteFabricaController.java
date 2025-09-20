package io.github.eduardolemos.arquiteturaspring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.eduardolemos.arquiteturaspring.montadora.CarroStatus;
import io.github.eduardolemos.arquiteturaspring.montadora.Chave;
import io.github.eduardolemos.arquiteturaspring.montadora.HondaCivic;
import io.github.eduardolemos.arquiteturaspring.montadora.Motor;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {
	
	@Autowired
	@Aspirado
	private Motor motor;

	@PostMapping
	public CarroStatus ligarCarro(@RequestBody Chave chave) {
		var carro = new HondaCivic(motor);
		return carro.darIgnicao(chave);
	}
}
