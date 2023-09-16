package Atividade9;

public class DecoracaoGelo extends AtaqueDecorador{

	public DecoracaoGelo(AtaqueStrategy atDecorado) {
		super(atDecorado);
		atDecorado.setValor(atDecorado.getValor()+2); //Aumenta o dano
		setDescricao("Espada congelante");
	}
}
