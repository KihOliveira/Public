package Atividade6;

public class Piromante extends Personagem{

	public Piromante(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Piromante");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		this.setA(new DecoracaoFogo(this.getA()));
	}
}
