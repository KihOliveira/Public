package Atividade9;

public class ComandoAbaixar implements Comando{

	private Personagem player;
	
	public ComandoAbaixar(Personagem player) {
		super();
		this.player = player;
	}

	@Override
	public void execute() {
		player.abaixar();
	}
	
}
