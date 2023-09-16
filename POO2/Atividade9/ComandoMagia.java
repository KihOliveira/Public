package Atividade9;

public class ComandoMagia implements Comando{

	private Personagem player;
	
	public ComandoMagia(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.magia();
	}
}
