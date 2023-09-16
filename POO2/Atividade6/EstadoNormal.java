package Atividade6;

public class EstadoNormal implements Estado {
	protected AtaqueStrategy a;
	protected Corrida c;

	public EstadoNormal() {
		super();
		this.a = new AtaqueMedio();
		this.c = new CorridaMedia();
	}

	@Override
	public Estado perdeVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo();
		}
		else if(life == 0) {
			return new EstadoMorto();
		}
		else return new EstadoNormal();
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life > 70) {
			return new EstadoForte();
		}
		else return new EstadoNormal();
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
	

