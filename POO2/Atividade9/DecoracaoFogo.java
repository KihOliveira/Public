package Atividade9;

public class DecoracaoFogo extends AtaqueDecorador{

	public DecoracaoFogo(AtaqueStrategy atDecorado) {
		super(atDecorado);
		atDecorado.setValor(atDecorado.getValor()+5); //Aumenta o dano
		setDescricao("Espada flamejante");
	}

}
