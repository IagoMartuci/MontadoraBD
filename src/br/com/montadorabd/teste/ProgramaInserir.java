package br.com.montadorabd.teste;

import br.com.montadorabd.beans.Carro;

public class ProgramaInserir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var carro = new Carro();

		carro.setModelo("Civic");
		carro.setCapacidadeCombustivel(50.0f);
		carro.setQuantidadePortas(4);
		
		System.out.println("Modelo: " + carro.getModelo() + "\nCapacidade do tanque de combustível: "
				+ carro.getCapacidadeCombustivel() + " litros" + "\nQuantidade de portas: "
				+ carro.getQuantidadePortas());
	}

}
