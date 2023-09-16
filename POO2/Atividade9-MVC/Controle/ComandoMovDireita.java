package Controle;

import Modelo.Personagem;

public class ComandoMovDireita implements Comando{
	
	private Personagem player;
	
	public ComandoMovDireita(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.moverDir();
	}
	
}
