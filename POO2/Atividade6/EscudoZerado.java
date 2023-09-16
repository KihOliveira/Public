package Atividade6;

public class EscudoZerado extends Escudo{

	@Override
	public int reduzDano(int dano) {
		System.out.println("Escudos zerados!");
		return dano;
	}

}
