package Atividade6;

public class AdvancedFactory {
	
	public static Personagem criaPersonagem() {
		Personagem p = new Personagem(0,0,"Default"); //Personagem base
		if(Math.random() <= 0.2) {
			p = new Piromante(p);
		}
		else if (Math.random() > 0.2 && Math.random() <= 0.4) {
			p = new Criomante(p);
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.6) {
			p = new ArautoTempestade(p);
		}
		else if (Math.random() > 0.6 && Math.random() <= 0.8) {
			p = new Paladino(p);
		}
		else if (Math.random() > 0.8) {
			p = new Dragoon(p);
		}
		return p;
	}
	
	public static Inimigo criaInimigo() {
		Inimigo i = new Inimigo(50,50,"Default"); //Inimigo base
		if(Math.random() <= 0.4) {
			i.setDano(10);
			i.setLife(20);
			i.setNome("Inimigo Pequeno");
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.9) {
			i.setDano(15);
			i.setLife(40);
			i.setNome("Inimigo Medio");
		}
		else if (Math.random() > 0.9) {
			i.setDano(30);
			i.setLife(60);
			i.setNome("Inimigo Grande");
		}
		return i;
	}
}
