package Atividade9;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FuturisticGame extends Game{
	
	private Personagem player;
	private Inimigo listaInimigos[]; // Mudanca pra um array de inimigos
	public int contagemInimigos;
	private Component dungeon;
	private FuturisticFactory fFact;
	
	public FuturisticGame(Fase fase) {
		super(fase);
		this.listaInimigos = new Inimigo[fase.getnInimigos()]; //Array do tamanho especificado pela fase
		this.contagemInimigos = fase.getnInimigos();
	}
	
	@Override
	public Personagem createPersonagem() {
		return fFact.criaPersonagem();
	}

	@Override
	public Inimigo createInimigo() {
		return fFact.criaInimigo();
	}
	

}
