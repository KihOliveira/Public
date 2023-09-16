package Atividade1;

public class Personagem2 extends Personagem{

	public Personagem2(Ataque a, Corrida c, Pulo p) {
		super(a, c, p);
		setA(new AtaqueMedio());
		setP(new PuloAlto());
	}

}
