package Controle;

import Modelo.Personagem;

public class ComandoMovBaixo implements Comando{
	
	private Personagem player;
	
	public ComandoMovBaixo(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.moverBaixo();
		
	}

}
