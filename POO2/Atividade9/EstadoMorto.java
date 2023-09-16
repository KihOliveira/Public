package Atividade9;

public class EstadoMorto implements Estado {
	protected AtaqueStrategy a;
	protected Corrida c;


	@Override
	public Estado perdeVida(int life) {
		System.out.println("Impossivel perder mais vida.");
		return null;
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo();
		}
		else if(life > 30 && life <70) {
			return new EstadoNormal();
		}
		else if( life >70) {
			return new EstadoForte();
		}
		else return new EstadoMorto();
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
