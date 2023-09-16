package Atividade6;

public class Dragoon extends Personagem{

	public Dragoon(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Dragoon");
		this.setLife(80);
		this.setE(new EstadoForte());
		this.setEstado(this.getE());
		
	}

}
