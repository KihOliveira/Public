package Atividade7;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FuturisticGame extends Game{
	private Personagem player;
	private Inimigo i1;
	private Inimigo i2;
	private Inimigo i3;
	private Inimigo i4;
	private Inimigo i5;
	private Inimigo i6;
	private FuturisticFactory fFact;
	
	@Override
	public Personagem createPersonagem() {
		return fFact.criaPersonagem();
	}

	@Override
	public Inimigo createInimigo() {
		return fFact.criaInimigo();
	}
	
}
