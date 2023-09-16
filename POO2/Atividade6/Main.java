package Atividade6;

public class Main {

	public static void main(String[] args)throws InterruptedException {
		
		Game g = new SimpleGame(); //Pode ser substituido por AdvancedGame
		g.jogar(g);
	}

}
