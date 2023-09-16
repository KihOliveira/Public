package Atividade9;

public class Abismo implements Component{

	@Override
	public void explorar(Personagem p) {
		System.out.println("Abismo encontrado. Game over.");		
	}

}
