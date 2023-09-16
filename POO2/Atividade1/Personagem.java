package Atividade1;

public abstract class Personagem {

	private Ataque a;
	private Corrida c;
	private Pulo p;
	
	
	public Personagem(Ataque a, Corrida c, Pulo p) {
		super();
		this.a = new AtaqueForte();
		this.c = new CorridaRapida();
		this.p = new PuloBaixo();
	}
	
	public Ataque getA() {
		return a;
	}

	public void setA(Ataque a) {
		this.a = a;
	}

	public Corrida getC() {
		return c;
	}

	public void setC(Corrida c) {
		this.c = c;
	}

	public Pulo getP() {
		return p;
	}

	public void setP(Pulo p) {
		this.p = p;
	}
	
	
	public void Atacar() {
		a.atacar();
		}
	
	public void correr() {
		c.correr();
	}
	
	public void pular() {
		p.pular();
	}
}
