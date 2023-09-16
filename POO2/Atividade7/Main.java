package Atividade7;

public class Main {

	public static void main(String[] args)throws InterruptedException {
		
		Game g = new MedievalGame(); //Pode ser substituido por FuturisticGame
		g.jogar(g);
	}

}
