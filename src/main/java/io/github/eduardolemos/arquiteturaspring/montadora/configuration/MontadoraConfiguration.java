package io.github.eduardolemos.arquiteturaspring.montadora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.github.eduardolemos.arquiteturaspring.montadora.Motor;
import io.github.eduardolemos.arquiteturaspring.montadora.TipoMotor;

@Configuration
public class MontadoraConfiguration {

	@Bean(name= "motorAspirado")
	public Motor motorAspirado() {
		var motor = new Motor();
		motor.setCavalos(120);
		motor.setCilindros(4);
		motor.setLitragem(2.0);
		motor.setModelo("2025");
		motor.setTipo(TipoMotor.ASPIRADO);
		return motor;
	}
	
	@Primary
	@Bean(name= "motorEletrico")
	public Motor motorEletrico() {
		var motor = new Motor();
		motor.setCavalos(80);
		motor.setCilindros(3);
		motor.setLitragem(1.4);
		motor.setModelo("2024");
		motor.setTipo(TipoMotor.ELETRICO);
		return motor;
	}
	
	
	@Bean(name= "motorTurbo")
	public Motor motorTurbo() {
		var motor = new Motor();
		motor.setCavalos(180);
		motor.setCilindros(4);
		motor.setLitragem(1.4);
		motor.setModelo("2025.2");
		motor.setTipo(TipoMotor.TURBO);
		return motor;
	}
	
	
}
