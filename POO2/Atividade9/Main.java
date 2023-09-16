package Atividade9;

public class Main {

	public static void main(String[] args)throws InterruptedException {
		Fase dungeon = new Fase(4,1,"Fase 1",new Abismo(), new Fase(4,2,"Fase 2",new Abismo(), new Fase(5,3,"Fase 3",new Abismo(),new Abismo())));
		Game g = new MedievalGame(dungeon); //Pode ser substituido por FuturisticGame
		g.jogar(g);
	}

}
