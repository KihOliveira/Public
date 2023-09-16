package Controle;

import Modelo.Personagem;

public class ComandoPular implements Comando{

	private Personagem player;
	
	public ComandoPular(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.pular();
	}
}
