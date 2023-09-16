package Atividade9;

public class Arqueiro extends Personagem{
	
	public Arqueiro(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Arqueiro");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		
	}
}
