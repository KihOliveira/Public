package Atividade8;
import java.util.ArrayList;
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
	private Inimigo listaInimigos[]; // Mudanca pra um array de inimigos
	public int contagemInimigos;
	private Component dungeon;
	
	public Game(Fase fase) {
		this.listaInimigos = new Inimigo[fase.getnInimigos()]; //Array do tamanho especificado pela fase
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
        
        for(Inimigo i: listaInimigos) {
        	g2d.setColor(Color.RED);
            g2d.fillOval(i.getX(), i.getY(), 20, 20);
        }
               
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
        for(Inimigo i: listaInimigos) {
        	i = createInimigo();
        }
        player = createPersonagem();
        
        //Add no array de observadores
        for(Inimigo i: listaInimigos) {
        	player.addObserver(i);
        }     
        
        while (true) {
        	for(Inimigo i: listaInimigos) {
            	if(i.getLife()<= 0) {
            		player.removeObserver(i);
            		contagemInimigos = contagemInimigos -1;
            	}
            }
            player.show();           
            game.repaint();
            Thread.sleep(50);
        }
    }
}

