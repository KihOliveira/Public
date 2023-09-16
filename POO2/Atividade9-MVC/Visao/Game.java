package Visao;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Component;
import javax.swing.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controle.ComandoAbaixar;
import Controle.ComandoAtacar;
import Controle.ComandoMagia;
import Controle.ComandoMovBaixo;
import Controle.ComandoMovCima;
import Controle.ComandoMovDireita;
import Controle.ComandoMovEsquerda;
import Controle.ComandoPular;
import Controle.Controle;
import Controle.Macro;
import Modelo.Inimigo;
import Modelo.Personagem;

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
	private static Controle c;
	
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
            	c.pressionar(0);
               
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            	c.pressionar(1);
               
            if (e.getKeyCode() == KeyEvent.VK_UP)
            	c.pressionar(2);
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            	c.pressionar(3);    
               
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
               c.pressionar(4);     
               
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
        
        //Controle
        c = new Controle();
        
        //Comandos de movimento
        c.setCommand(new ComandoMovEsquerda(player),0);
        c.setCommand(new ComandoMovDireita(player),1);
        c.setCommand(new ComandoMovCima(player),2);
        c.setCommand(new ComandoMovBaixo(player),3);
        
        //Comandos de acoes
        c.setCommand(new ComandoAtacar(player),4);
        c.setCommand(new ComandoPular(player),5);
        c.setCommand(new ComandoAbaixar(player),6);
        c.setCommand(new ComandoMagia(player),7);
        
        //Macros
        Macro m = new Macro();
        m.addCommand(new ComandoPular(player));
        m.addCommand(new ComandoAbaixar(player));
        m.addCommand(new ComandoPular(player));
        
        Macro m1 = new Macro();
        m1.addCommand(new ComandoAtacar(player));
        m1.addCommand(new ComandoMagia(player));
        m1.addCommand(new ComandoAtacar(player));
        
        Macro m2 = new Macro();
        m2.addCommand(new ComandoMovEsquerda(player));
        m2.addCommand(new ComandoMovCima(player));
        m2.addCommand(new ComandoMovDireita(player));
        m2.addCommand(new ComandoMovBaixo(player));
        
        c.setCommand(m, 8);
        c.setCommand(m1, 9);
        c.setCommand(m2, 10);
        
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

