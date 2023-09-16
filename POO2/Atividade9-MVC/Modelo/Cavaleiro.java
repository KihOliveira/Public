package Modelo;

public class Cavaleiro extends Personagem{
	
	public Cavaleiro(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Cavaleiro");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		this.setLife(70);
	}
}
