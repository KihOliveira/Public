package Atividade4;

public class EstadoPerigo implements Estado{
	protected Ataque a;
	protected Corrida c;

	public EstadoPerigo(Ataque a, Corrida c) {
		super();
		this.a = new AtaqueFraco();
		this.c = new CorridaDevagar();
	}

	@Override
	public Estado perdeVida(int life) {
		if( life <=0) {
			return new EstadoMorto();
		}
		else return new EstadoPerigo(new AtaqueFraco(),new CorridaDevagar());
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life >30 && life <70) {
			return new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
		}
		else if(life>70) {
			return new EstadoForte(new AtaqueForte(),new CorridaRapida());
		}
		else return new EstadoPerigo(new AtaqueFraco(),new CorridaDevagar());
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
