package Modelo;

public class EstadoPerigo implements Estado{
	protected AtaqueStrategy a;
	protected Corrida c;

	public EstadoPerigo() {
		super();
		this.a = new AtaqueFraco();
		this.c = new CorridaDevagar();
	}

	@Override
	public Estado perdeVida(int life) {
		if( life <=0) {
			return new EstadoMorto();
		}
		else return new EstadoPerigo();
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life >30 && life <70) {
			return new EstadoNormal();
		}
		else if(life>70) {
			return new EstadoForte();
		}
		else return new EstadoPerigo();
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
