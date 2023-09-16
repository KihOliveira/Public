package Atividade6;

public class Criomante extends Personagem{
	
	public Criomante(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Criomante");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		this.setA(new DecoracaoGelo(this.getA()));
	}
}
