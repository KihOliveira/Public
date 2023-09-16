package Atividade9;

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
