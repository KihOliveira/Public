package Controle;

import Modelo.Personagem;

public class ComandoAtacar implements Comando{

	private Personagem player;
	
	public ComandoAtacar(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.atacar();
	}
	
}
