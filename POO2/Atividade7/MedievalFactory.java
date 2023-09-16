package Atividade7;

public class MedievalFactory extends AbstractFactory{
	
	private static MedievalFactory instancia = null;
	
	public static synchronized MedievalFactory getInstancia() {
		 if (instancia == null)
		 instancia = new MedievalFactory();
		 return instancia;
		 }
	
	@Override
	public Personagem criaPersonagem() {
		Personagem p = new Personagem(0,0,"Default");
		if(Math.random() <= 0.5) {
			 p = new Arqueiro(p);
		}
		else if (Math.random() > 0.5) {
			 p = new Cavaleiro(p);
		}
		return p;
	}
	
	@Override
	public Inimigo criaInimigo() {
		Inimigo i = new Inimigo(50,50,"Default"); //Inimigo base
		if(Math.random() <= 0.4) {
			i.setDano(10);
			i.setLife(20);
			i.setNome("Aldeao");
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.9) {
			i.setDano(15);
			i.setLife(40);
			i.setNome("Guarda");
		}
		else if (Math.random() > 0.9) {
			i.setDano(30);
			i.setLife(60);
			i.setNome("Paladino");
		}
		return i;
	}

	@Override
	public Escudo criaDefesa() {
		Escudo escudoMedieval = new EscudoMedio();
		return escudoMedieval;
	}

}
