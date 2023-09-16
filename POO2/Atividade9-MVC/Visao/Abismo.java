package Visao;

import Modelo.Component;
import Modelo.Personagem;

public class Abismo implements Component{

	@Override
	public void explorar(Personagem p) {
		System.out.println("Abismo encontrado. Game over.");		
	}

}
