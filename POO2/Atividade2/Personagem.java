package Atividade2;

public class Personagem {

	private Ataque a;
	private Corrida c;
	private Estado e;
	private int life;
	
	public Personagem() {
		super();
		this.life = 70;
		this.e = new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
		setEstado(e);
	}
	
	public void mostraEstado() {
		System.out.println("Estado atual: "+this.getE());
		System.out.println("Ataque atual: "+e.getA());
		System.out.println("Corrida atual: "+e.getC());
	}
	
	public void perderVida(int life) {
		this.life = this.life - life;
		  setEstado(e.perdeVida(this.life));
	}
	
	public void ganharVida(int life) {
		this.life = this.life + life;
		setEstado(e.ganhaVida(this.life));
	}
	
	public void setEstado(Estado e) {
		setE(e);
		setA(e.getA());
		setC(e.getC());
	}
	
	public Ataque getA() {
		return this.a;
	}

	public void setA(Ataque a) {
		this.a = a;
	}

	public Corrida getC() {
		return this.c;
	}

	public void setC(Corrida c) {
		this.c = c;
	}
	
	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void Atacar() {
		a.atacar();
		}
	
	public void correr() {
		c.correr();
	}
}
