package Atividade8;

public class DecoracaoTrovao extends AtaqueDecorador{

	public DecoracaoTrovao(AtaqueStrategy atDecorado) {
		super(atDecorado);
		atDecorado.setValor(atDecorado.getValor()+3); //Aumenta o dano
		setDescricao("Espada trovejante");
	}
}
