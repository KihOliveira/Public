package Atividade6;

public class ArautoTempestade extends Personagem {
	
	public ArautoTempestade(Personagem personagem) {
		super(personagem.getX(),personagem.getY(),personagem.getNome());
		this.setNome("Arauto da Tempestade");
		this.setE(new EstadoNormal());
		this.setEstado(this.getE());
		this.setA(new DecoracaoTrovao(this.getA()));
	}
}
