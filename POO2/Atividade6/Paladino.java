package Atividade6;

public class Paladino extends Personagem{

	public Paladino(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Paladino");
		this.setE(new EstadoForte());
		this.setEstado(this.getE());
		this.setLife(100);
		this.setA(new DecoracaoFogo(this.getA()));
	}
}
