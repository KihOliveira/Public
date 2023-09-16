package Atividade2;

public class Main {

	public static void main(String[] args) {
		Personagem player = new Personagem(); //Inicia com 70 de vida, estado normal
		player.mostraEstado();
		player.ganharVida(30); //Ganha 30 de vida, fica com 100, estado forte
		player.mostraEstado();
		player.perderVida(71); //Perde 71 de vida, fica com 29, estado perigo
		player.mostraEstado();
		player.perderVida(29); //Perde 29 de vida, fica com 0, estado morto
		player.mostraEstado();
	}

}
