package Atividade6;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdvancedGame extends Game{
	private Personagem player;
	private Inimigo i1;
	private Inimigo i2;
	private Inimigo i3;
	private Inimigo i4;
	private Inimigo i5;
	private Inimigo i6;
	
	@Override
	public Personagem createPersonagem() {
		Personagem p = new Personagem(0,0,"Default"); //Personagem base
		p = AdvancedFactory.criaPersonagem();
		return p;
	}

	@Override
	public Inimigo createInimigo() {
		Inimigo i = new Inimigo(50,50,"Default"); //Inimigo base
		i = AdvancedFactory.criaInimigo();
		return i;
	}
	
	@Override
	public void jogar(Game game) throws InterruptedException{
		int x = 1024;
        int y = 768;
        JFrame frame = new JFrame("Raid");
        
        ImageIcon background = new ImageIcon("mapa.jpg");

        JLabel label = new JLabel();
        
        JLabel contagem = new JLabel("Inimigos vivos: "+contagemInimigos);
        add(contagem);
        
        label.setBounds(0, 0, x, y);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);
        
        frame.getContentPane().add(game);
        frame.setSize(x, y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        //Cria os inimigos e jogador usando a fabrica simples
        i1 = createInimigo();
        i2 = createInimigo();
        i3 = createInimigo();
        i5 = createInimigo();
        i4 = createInimigo();
        i6 = createInimigo();
        player = createPersonagem();
        
        //Add no array de observadores
        player.addObserver(i1);
        player.addObserver(i2);
        player.addObserver(i3);        
        player.addObserver(i4);        
        player.addObserver(i5);        
        player.addObserver(i6);       
       
        
        if(i1.getLife() <=0) {
        	player.removeObserver(i1);
        	contagemInimigos--;
        }
        if(i2.getLife() <=0) {
        	player.removeObserver(i2);
        	contagemInimigos--;
        }
        if(i3.getLife() <=0) {
        	player.removeObserver(i3);
        	contagemInimigos--;
        	player.setA(new DecoracaoGelo(player.getA()));//Se derrotado melhorara o ataque do jogador
        }
        if(i4.getLife() <=0) {
        	player.removeObserver(i4);
        	contagemInimigos--;
        	player.setA(new DecoracaoTrovao(player.getA()));//Se derrotado melhorara o ataque do jogador
        }
        if(i5.getLife() <=0) {
        	player.removeObserver(i5);
        	contagemInimigos--;
        	player.setA(new DecoracaoFogo(player.getA())); //Se derrotado melhorara o ataque do jogador
        }
        if(i6.getLife() <=0) {
        	player.removeObserver(i6);
        	contagemInimigos--;
        }
       
        
        while (true) {
            player.show();           
            game.repaint();
            Thread.sleep(50);
        }
    }
}
