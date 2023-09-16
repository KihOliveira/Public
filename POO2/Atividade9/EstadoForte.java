package Atividade9;

public class EstadoForte implements Estado {
	protected AtaqueStrategy a;
	protected Corrida c;
	
	public EstadoForte() {
		super();
		this.a = new AtaqueForte();
		this.c = new CorridaRapida();
	}

	@Override
	public Estado perdeVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo();
		}
		else if(life > 30 && life <70) {
			return new EstadoNormal();
		}
		else if(life == 0) {
			return new EstadoMorto();
		}
		else return new EstadoForte();
	}

	@Override
	public Estado ganhaVida(int life) {
		System.out.println("Já está no estado forte.");
		return new EstadoForte();
	}
	
	@Override
	public AtaqueStrategy getA() {
		return this.a;
	}


	@Override
	public Corrida getC() {
		return this.c;
	}
	
}
