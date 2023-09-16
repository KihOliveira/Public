package Atividade8;

public class Robo extends Personagem{

	public Robo(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Arqueiro");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		
	}
}
