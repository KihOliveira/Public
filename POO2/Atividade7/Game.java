package Atividade7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Component;
import javax.swing.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public abstract class Game extends JPanel {
	public abstract Personagem createPersonagem();
	public abstract Inimigo createInimigo();
	private Personagem player;
	private Inimigo i1;
	private Inimigo i2;
	private Inimigo i3;
	private Inimigo i4;
	private Inimigo i5;
	private Inimigo i6;
	public int contagemInimigos;
	
	public Game() {
		contagemInimigos = 6;
		KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true); 
        
	}
	
	public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
         

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            	player.setX(player.getX()-10);
               
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            	player.setX(player.getX()+10);
               
            if (e.getKeyCode() == KeyEvent.VK_UP)
            	player.setY(player.getY()-10);
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
               player.setY(player.getY()+10);    
               
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
               player.atacar();        
               
        }
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
}
	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
       
        g2d.setColor(Color.BLACK);
        g2d.fillOval(i6.getX(), i6.getY(), 20, 20);

        g2d.setColor(Color.RED);                
        g2d.fillOval(i5.getX(), i5.getY(), 20, 20);

        g2d.setColor(Color.RED);                
        g2d.fillOval(i4.getX(), i4.getY(), 20, 20);
        
        g2d.setColor(Color.ORANGE);                        
        g2d.fillOval(i1.getX(), i1.getY(), 20, 20);
        
        g2d.setColor(Color.ORANGE);                        
        g2d.fillOval(i2.getX(), i2.getY(), 20, 20);
        
        g2d.setColor(Color.ORANGE);                        
        g2d.fillOval(i3.getX(), i3.getY(), 20, 20);
        
        g2d.setColor(Color.BLUE);                        
        g2d.fillOval(player.getX(), player.getY(), 20, 20);
               
    }
	public void jogar(Game game) throws InterruptedException {
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
        
        //Cria os inimigos e jogador usando a fabrica
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

