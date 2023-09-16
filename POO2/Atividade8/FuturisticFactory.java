package Atividade8;

public class FuturisticFactory extends AbstractFactory{

	private static FuturisticFactory instancia = null;
	
	public static synchronized FuturisticFactory getInstancia() {
		 if (instancia == null)
		 instancia = new FuturisticFactory();
		 return instancia;
		 }
	
	@Override
	public Personagem criaPersonagem() {
		Personagem p = new Personagem(0,0,"Default");
		p = new Robo(p);
		return p;
	}

	@Override
	public Inimigo criaInimigo() {
		Inimigo i = new Inimigo(50,50,"Default"); //Inimigo base
		if(Math.random() <= 0.4) {
			i.setDano(10);
			i.setLife(20);
			i.setNome("Robo");
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.9) {
			i.setDano(15);
			i.setLife(40);
			i.setNome("Ciborgue");
		}
		else if (Math.random() > 0.9) {
			i.setDano(30);
			i.setLife(60);
			i.setNome("ExMachina");
		}
		return i;
	}

	@Override
	public Escudo criaDefesa() {
		Escudo campoMag = new EscudoMedio();
		return campoMag;
	}

}
