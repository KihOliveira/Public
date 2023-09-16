package Atividade9;

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
