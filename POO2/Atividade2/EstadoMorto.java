package Atividade2;

public class EstadoMorto implements Estado {
	protected Ataque a;
	protected Corrida c;


	@Override
	public Estado perdeVida(int life) {
		System.out.println("Impossivel perder mais vida.");
		return null;
	}

	@Override
	public Estado ganhaVida(int life) {
		if(life >0 && life<30) {
			return new EstadoPerigo(new AtaqueFraco(),new CorridaDevagar());
		}
		else if(life > 30 && life <70) {
			return new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
		}
		else if( life >70) {
			return new EstadoForte(new AtaqueForte(),new CorridaRapida());
		}
		else return new EstadoMorto();
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
