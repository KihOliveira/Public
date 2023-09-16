package Atividade9;

import java.awt.Component;

public class MedievalGame extends Game{
	
	private Personagem player;
	private MedievalFactory mFact = new MedievalFactory();
	private Inimigo listaInimigos[]; // Mudanca pra um array de inimigos
	public int contagemInimigos;
	private Component dungeon;
	
	public MedievalGame(Fase fase) {
		super(fase);
		this.listaInimigos = new Inimigo[fase.getnInimigos()]; //Array do tamanho especificado pela fase
		this.contagemInimigos = fase.getnInimigos();
	}

	@Override
	public Personagem createPersonagem() {
		return mFact.criaPersonagem();
	}
	
	@Override
	public Inimigo createInimigo() {
		return mFact.criaInimigo();
	}
	
	
/*	public void criaInimigo() {
		for(int i =0; i<this.contagemInimigos;i++) {
			this.listaInimigos[i] = new Inimigo(50,50,"Default");
		}
		for(Inimigo i: listaInimigos) {
			i = mFact.criaInimigo();
		}
	} */
	
}

