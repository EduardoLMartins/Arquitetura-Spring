package io.github.eduardolemos.arquiteturaspring.montadora;

import java.awt.Color;

public class HondaCivic extends Carro{

	public HondaCivic(Motor motor) {
		super(motor);
		setModelo("Civic");
		setCor(Color.BLACK);
		setMontadora(Montadora.HONDA);
	}

	
}
