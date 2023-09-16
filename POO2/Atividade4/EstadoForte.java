package Atividade4;

public class EstadoForte implements Estado {
	protected Ataque a;
	protected Corrida c;
	
	public EstadoForte(Ataque a, Corrida c) {
		super();
		this.a = new AtaqueForte();
		this.c = new CorridaRapida();
	}

	@Override
	public Estado perdeVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo(new AtaqueFraco(),new CorridaDevagar());
		}
		else if(life > 30 && life <70) {
			return new EstadoNormal(new AtaqueMedio(),new CorridaMedia() );
		}
		else if(life == 0) {
			return new EstadoMorto();
		}
		else return new EstadoForte(new AtaqueForte(),new CorridaRapida());
	}

	@Override
	public Estado ganhaVida(int life) {
		System.out.println("Já está no estado forte.");
		return new EstadoForte(new AtaqueForte(),new CorridaRapida());
	}
	
	@Override
	public Ataque getA() {
		return this.a;
	}


	@Override
	public Corrida getC() {
		return this.c;
	}
	
}
