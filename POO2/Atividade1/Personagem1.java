package Atividade1;

public class Personagem1 extends Personagem{

	public Personagem1(Ataque a, Corrida c, Pulo p) {
		super(a, c, p);
		setP(new PuloMedio());
		setC(new CorridaMedia());
	}
	

}
