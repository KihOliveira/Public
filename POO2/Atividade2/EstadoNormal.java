package Atividade2;

public class EstadoNormal implements Estado {
	protected Ataque a;
	protected Corrida c;

	public EstadoNormal(Ataque a, Corrida c) {
		super();
		this.a = new AtaqueMedio();
		this.c = new CorridaMedia();
	}

	@Override
	public Estado perdeVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo(new AtaqueFraco(),new CorridaDevagar());
		}
		else if(life == 0) {
			return new EstadoMorto();
		}
		else return new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life > 70) {
			return new EstadoForte(new AtaqueForte(),new CorridaRapida());
		}
		else return new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
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
	

